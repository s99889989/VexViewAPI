package lk.vexview.additional.listener;

import com.daxton.unrealcore.display.event.gui.PlayerGUICloseEvent;
import com.daxton.unrealcore.display.event.gui.PlayerGUIOpenEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        // 检查关闭界面的是不是玩家
        if (event.getPlayer() instanceof Player) {
            Player player = (Player) event.getPlayer();
//            SchedulerFunction.runLater(Main.main, ()->{
//                UnrealCoreAPI.inst(player).getGUIHelper().closeGUI();
//            }, 1);

        }
    }

    @EventHandler//當玩家打開GUI
    public void onGUIOpen(PlayerGUIOpenEvent event) {
        String name = event.getGuiName();
//        Main.sendLogger(name+" 打開");
    }

    @EventHandler//當玩家關閉GUI
    public void onGUIClose(PlayerGUICloseEvent event) {
        String name = event.getGuiName();
//        Main.sendLogger(name+" 關閉");
//        SchedulerFunction.runLater(Main.main, ()->{
//            if(UnrealCoreAPI.inst(event.getPlayer()).getGUIHelper().getUnrealCoreGUI() == null){
//                Main.sendLogger(name+" 無");
//            }else {
//                Main.sendLogger(name+" 有");
//            }
//        }, 10);
    }

}
