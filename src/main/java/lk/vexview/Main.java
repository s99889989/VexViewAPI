package lk.vexview;

import com.daxton.unrealcore.UnrealCorePlugin;
import com.daxton.unrealcore.nms.NMSVersion;
import lk.vexview.additional.command.VexViewCommand;
import lk.vexview.additional.command.VexViewTab;
import lk.vexview.additional.controller.VexViewController;
import lk.vexview.additional.listener.VexViewGUIListener;
import lk.vexview.additional.listener.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;
import java.util.Objects;

public final class Main extends JavaPlugin {

    public static UnrealCorePlugin unrealCorePlugin;

    public static Main main;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§2======== §6VexView > 開始啟動 §2========");
        Bukkit.getConsoleSender().sendMessage("§2> §b歡迎使用VexView！");
        Locale defaultLocale = Locale.getDefault();
        Bukkit.getConsoleSender().sendMessage("§2> 已將您的語言設置為：§f"+defaultLocale.getDisplayCountry()+" ("+defaultLocale+")");
        String minecraftVersion = NMSVersion.getMinecraftVersion();
        if(NMSVersion.getMinecraftVersionSize(minecraftVersion) >= 28){
            Bukkit.getConsoleSender().sendMessage("§2> 當前服務器版本： §f"+ NMSVersion.getMinecraftVersion()+" §2(已兼容)");
        }else {
            Bukkit.getConsoleSender().sendMessage("§2> 當前服務器版本： §f"+ NMSVersion.getMinecraftVersion()+" §4(不兼容)");
        }
        Bukkit.getConsoleSender().sendMessage("§2> §b該遊戲版本已開放使用的功能：");
        Bukkit.getConsoleSender().sendMessage("§2 ┣ §fGUI基础功能 §2√");
        Bukkit.getConsoleSender().sendMessage("§2 ┣ §fTAG基础功能 §4✘");
        Bukkit.getConsoleSender().sendMessage("§2 ┣ §fVexViewStore商店 §4✘");
        Bukkit.getConsoleSender().sendMessage("§2 ┣ §f自定义药水效果 §4✘");
        Bukkit.getConsoleSender().sendMessage("§2 ┣ §f高级特效 §4✘");
        Bukkit.getConsoleSender().sendMessage("§2 ┣ §f高级物品提示框 §4✘");
        Bukkit.getConsoleSender().sendMessage("§2 ┣ §f自定义游戏菜单 §4✘");
        Bukkit.getConsoleSender().sendMessage("§2 ┗ §f其他功能 §4✘");
        Bukkit.getConsoleSender().sendMessage("> 檢測到未啟用數據庫");
        if(Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null){
            Bukkit.getConsoleSender().sendMessage("§2> PlaceholderAPI 插件成功兼容！");
        }else {
            Bukkit.getConsoleSender().sendMessage("§2> §fPlaceholderAPI 插件未安裝，跳過兼容！");
        }
        Bukkit.getConsoleSender().sendMessage("§2> §f已完成VexView插件全部功能載入！");
        Bukkit.getConsoleSender().sendMessage("§2> 作者 §fLK520 §2|§flona §2版本: §f2.7.4");
        main = this;
        unrealCorePlugin = new UnrealCorePlugin(this);


        VexViewController.load();

        Objects.requireNonNull(Bukkit.getPluginCommand("opengui")).setExecutor(new VexViewCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("opengui")).setTabCompleter(new VexViewTab());
        Objects.requireNonNull(Bukkit.getPluginCommand("vexreload")).setExecutor(new VexViewCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("vexreload")).setTabCompleter(new VexViewTab());

        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new VexViewGUIListener(), this);

        Bukkit.getConsoleSender().sendMessage("§2======== §6VexView > 啟動完成 §2========");
    }

    @Override
    public void onDisable() {

    }

}
