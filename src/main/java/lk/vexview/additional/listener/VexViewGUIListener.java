package lk.vexview.additional.listener;

import com.daxton.unrealcore.application.UnrealCoreAPI;
import com.daxton.unrealcore.common.event.PlayerKeyBoardEvent;
import com.daxton.unrealcore.common.event.PlayerWindowReSizeEvent;
import lk.vexview.event.KeyBoardHoldEvent;
import lk.vexview.event.KeyBoardPressEvent;
import lk.vexview.event.PlayerClientWindowSizeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VexViewGUIListener implements Listener {

    //按下按鍵
    @EventHandler
    public void onPlayerKeyBoard(PlayerKeyBoardEvent event){
        Player player = event.getPlayer();
        String uuidString = player.getUniqueId().toString();
        int keyID = event.getKeyID();
        String keyName = event.getKeyName();
        boolean inputNow = event.isInputNow();
        int keyAction = event.getKeyAction();

        String typeString = "NOGUI";
        if(UnrealCoreAPI.inst(player).getGUIHelper().getUnrealCoreGUI() != null){
            typeString = "GUI";
        }

        //按住
        if(keyAction == 2){
            KeyBoardHoldEvent keyBoardHoldEvent = new KeyBoardHoldEvent(keyID, player, typeString);
            Bukkit.getPluginManager().callEvent(keyBoardHoldEvent);
        }
        //按下
        if(keyAction == 1){
            KeyBoardPressEvent keyBoardPressEvent = new KeyBoardPressEvent(keyID, player, false, typeString);
            Bukkit.getPluginManager().callEvent(keyBoardPressEvent);
        }
        //放開
        if(keyAction == 0){
            KeyBoardPressEvent keyBoardPressEvent = new KeyBoardPressEvent(keyID, player, true, typeString);
            Bukkit.getPluginManager().callEvent(keyBoardPressEvent);
        }

    }

//    @EventHandler//當玩家按下按鈕
//    public void onButton(PlayerButtonEvent event) {
//        Player player = event.getPlayer();
//        String uuidString = player.getUniqueId().toString();
//        if(GUIController.mainGUIDataMap.containsKey(uuidString)){
//            UnrealCoreGUI unrealCoreGUI = GUIController.mainGUIDataMap.get(uuidString);
//            if(unrealCoreGUI instanceof VexCoreGUI){
//                VexCoreGUI vexCoreGUI = (VexCoreGUI) unrealCoreGUI;
//                MouseButtonType button = event.getButton();
//                MouseActionType action = event.getAction();
//                ModuleComponents moduleComponents = unrealCoreGUI.getTriggerModule(event.getPath(), event.getModuleID());
//                if(moduleComponents == null){
//                    return;
//                }
//                ButtonModule buttonModule = (ButtonModule) moduleComponents;
//                VexButton vexButton = null;
//                if(button == MouseButtonType.Left && action == MouseActionType.Off){
//                    if(buttonModule.getPath().isEmpty()){
//                        vexButton = vexCoreGUI.getVexGui().getButtonById(buttonModule.getModuleID());
//                    }else {
//                        String path = buttonModule.getPath().get(0);
//                        VexScrollingList vexScrollingList = vexCoreGUI.getVexGui().getVexScrollingList(path);
//                        if(vexScrollingList == null){return;}
//                        vexButton = vexScrollingList.getButtonById(buttonModule.getModuleID());
//                    }
//                }
//                if(vexButton != null){
//                    ButtonClickEvent buttonClickEvent = new ButtonClickEvent(vexButton, vexCoreGUI.getVexGui(), player);
//                    Bukkit.getPluginManager().callEvent(buttonClickEvent);
//                }
//
//
//            }
//        }
//    }

    @EventHandler //視窗大小改變
    public void onWindowsReSize(PlayerWindowReSizeEvent event){
        Player player = event.getPlayer();
        int scaledWidth = event.getScaledWidth();
        int scaledHeight = event.getScaledHeight();
        PlayerClientWindowSizeEvent playerClientWindowSizeEvent = new PlayerClientWindowSizeEvent(player, scaledWidth, scaledHeight);
        Bukkit.getPluginManager().callEvent(playerClientWindowSizeEvent);
    }

}
