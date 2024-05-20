package lk.vexview.additional.controller;

import com.daxton.unrealcore.application.UnrealCoreAPI;
import com.daxton.unrealcore.application.base.PluginUtil;
import lk.vexview.Main;
import lk.vexview.additional.gui.UnrealGUIContainer;
import lk.vexview.api.VexViewAPI;
import lk.vexview.gui.VexGui;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class VexViewController {


    //GUI列表
    public static Map<String, FileConfiguration> unrealCoreGUIMap = new HashMap<>();

    public static void load(){

        createConfig();
        unrealCoreGUIMap = Main.unrealCorePlugin.findYmlMap("gui");
    }

    public static void reload(){
        load();
    }

    //打開GUI
    public static void open(Player player, String guiName){
        if(!unrealCoreGUIMap.containsKey(guiName)){return;}
        FileConfiguration fileConfiguration = unrealCoreGUIMap.get(guiName);
        VexGui vexGui = new VexGui(fileConfiguration);
        VexViewAPI.openGui(player, vexGui);
//        UnrealGUIContainer unrealGUIContainer = new UnrealGUIContainer(player,"VexView", vexGui);
//        UnrealCoreAPI.inst(player).getGUIHelper().openCoreGUI(unrealGUIContainer);
    }

    //建立設定檔
    public static void createConfig(){
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/button/test.yml", "button/test.yml", false);
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/gifimage/example.yml", "gifimage/example.yml", false);
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/gui/normal.yml", "gui/normal.yml", false);
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/image/example.yml", "image/example.yml", false);
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/slot/apple.yml", "slot/apple.yml", false);
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/tag/default.yml", "tag/default.yml", false);
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/text/text.yml", "text/text.yml", false);
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/gamemenu.yml", "gamemenu.yml", false);
        PluginUtil.resourceCopy(Main.unrealCorePlugin.getJavaPlugin(), "resource/verification.yml", "verification.yml", false);
    }

}
