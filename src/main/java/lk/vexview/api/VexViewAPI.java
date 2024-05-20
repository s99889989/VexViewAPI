package lk.vexview.api;

import com.daxton.unrealcore.UnrealCore;
import com.daxton.unrealcore.application.UnrealCoreAPI;
import com.daxton.unrealcore.application.method.SchedulerFunction;
import com.daxton.unrealcore.been.effects.been.EntityEffectsImageBeen;
import com.daxton.unrealcore.been.effects.been.EntityEffectsTextBeen;
import com.daxton.unrealcore.display.been.module.display.ImageModuleData;
import com.daxton.unrealcore.display.been.module.display.TextModuleData;
import lk.vexview.Main;
import lk.vexview.VexView;
import lk.vexview.gui.OpenedVexGui;

import lk.vexview.gui.VexCoreGUI;
import lk.vexview.gui.VexGui;
import lk.vexview.hud.VexImageShow;
import lk.vexview.hud.VexShow;
import lk.vexview.hud.VexTextShow;
import lk.vexview.tag.components.VexImageTag;
import lk.vexview.tag.components.VexTag;
import lk.vexview.tag.components.VexTextTag;
import org.bukkit.Bukkit;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class VexViewAPI {

    //GUI
    //================================================================================//

    public static Map<String, VexCoreGUI> vexCoreGUIMap = new ConcurrentHashMap<>();

    public static OpenedVexGui getPlayerCurrentGui(Player player) {
        String uuidString = player.getUniqueId().toString();
        if(vexCoreGUIMap.containsKey(uuidString)){
            return vexCoreGUIMap.get(uuidString).getOpenedVexGui();
        }
        return new OpenedVexGui(null, new VexGui(), player);
    }

    public static void openGui(Player player, VexGui vexGui) {
        String uuidString = player.getUniqueId().toString();
        Inventory largeChest = Bukkit.createInventory(null, 54, "VexViewAPI");
        player.openInventory(largeChest);
        if(UnrealCoreAPI.inst(player).getGUIHelper().getUnrealCoreGUI() != null){
            vexCoreGUIMap.remove(uuidString);
            UnrealCoreAPI.inst(player).getGUIHelper().closeCoreGUI();

        }

        SchedulerFunction.runLater(Main.main, ()->{

//            int size = player.getOpenInventory().getTopInventory().getSize()+player.getOpenInventory().getBottomInventory().getSize();
//            UnrealCore.sendLogger("大小0: "+size);
            VexCoreGUI vexCoreGUI = new VexCoreGUI(player, vexGui, largeChest);
            vexCoreGUIMap.put(uuidString, vexCoreGUI);
            UnrealCoreAPI.inst(player).getGUIHelper().openCoreGUI(vexCoreGUI);
//            int size2 = player.getOpenInventory().getTopInventory().getSize()+player.getOpenInventory().getBottomInventory().getSize();
//            UnrealCore.sendLogger("大小1: "+size2);
        }, 1);


//        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(new File(Main.getResourceFolder(),"g/GUIExample.yml"));
//        UnrealGUIContainer unrealGUIContainer = new UnrealGUIContainer("VV", fileConfiguration);
//        UnrealCoreAPI.inst(player).getGUIHelper().openCoreGUI(unrealGUIContainer);


    }


    public static void sendFlowView(Player player, String text, int tick, boolean a) {
//        Main.sendLogger(text);
    }

    public static VexView getVexView() {
        return VexView.getInstance();
    }

    //HUD
    //================================================================================//

    public static void sendHUD(Player player, VexShow vexShow) {
        if(vexShow instanceof VexImageShow){
            VexImageShow vexImageShow = (VexImageShow) vexShow;
            UnrealCore.sendLogger(vexImageShow.toString());
            ImageModuleData imageModuleData = new ImageModuleData(vexImageShow.getId(), 0, vexImageShow.getX(), vexImageShow.getY(), vexImageShow.getUrl(), vexImageShow.getWidth(), vexImageShow.getHeight());
            UnrealCoreAPI.inst(player).getHUDHelper().setHUD(imageModuleData);
        }
        if(vexShow instanceof VexTextShow){
            VexTextShow vexTextShow = (VexTextShow) vexShow;
            TextModuleData textModuleData = new TextModuleData(vexTextShow.getId(), 0, vexTextShow.getX(), vexTextShow.getY(), vexTextShow.getL(), 1, 10);
            UnrealCoreAPI.inst(player).getHUDHelper().setHUD(textModuleData);
        }
    }

    public static void sendHUD(Player player, VexShow vexShow, double x, double y) {
        if(vexShow instanceof VexImageShow){
            VexImageShow vexImageShow = (VexImageShow) vexShow;
            vexImageShow.setX((int) x);
            vexImageShow.setY((int) y);
            ImageModuleData imageModuleData = new ImageModuleData(vexImageShow.getId(), 0, vexImageShow.getX(), vexImageShow.getY(), vexImageShow.getUrl(), vexImageShow.getWidth(), vexImageShow.getHeight());
            UnrealCoreAPI.inst(player).getHUDHelper().setHUD(imageModuleData);
        }
        if(vexShow instanceof VexTextShow){
            VexTextShow vexTextShow = (VexTextShow) vexShow;
            vexTextShow.setX((int) x);
            vexTextShow.setY((int) y);
            TextModuleData textModuleData = new TextModuleData(vexTextShow.getId(), 0, vexTextShow.getX(), vexTextShow.getY(), vexTextShow.getL(), 1, 10);
            UnrealCoreAPI.inst(player).getHUDHelper().setHUD(textModuleData);
        }
    }

    public static void removeHUD(Player player, int a) {
        UnrealCoreAPI.inst(player).getHUDHelper().removeHUD(String.valueOf(a));
    }

    public static void removeHUD(Player player, Object object) {
        UnrealCoreAPI.inst(player).getHUDHelper().removeHUD(object.toString());
    }

    //Tag
    //================================================================================//

    public static Map<UUID, List<VexTag>> entityVexTag = new ConcurrentHashMap<>();

    public static void removePlayerTag(Player player, Object oID) {
        UUID uuid = player.getUniqueId();
        String uuidString = uuid.toString();
        String id = oID.toString();

        if(entityVexTag.containsKey(uuid)){
            for(VexTag vexTag : entityVexTag.get(uuid)){
                if(vexTag.getId().equals(id)){
                    entityVexTag.get(uuid).remove(vexTag);
                    UnrealCoreAPI.inst(player).getEntityEffectsHelper().removeImage(uuidString, id);
                    UnrealCoreAPI.inst(player).getEntityEffectsHelper().removeText(uuidString, id);
                }
            }
        }

    }

    public static void removePlayerTag(Player player, String id) {
        UUID uuid = player.getUniqueId();
        String uuidString = uuid.toString();
        if(entityVexTag.containsKey(uuid)){
            for(VexTag vexTag : entityVexTag.get(uuid)){
                if(vexTag.getId().equals(id)){
                    entityVexTag.get(uuid).remove(vexTag);
                    UnrealCoreAPI.inst(player).getEntityEffectsHelper().removeImage(uuidString, id);
                    UnrealCoreAPI.inst(player).getEntityEffectsHelper().removeText(uuidString, id);
                }
            }
        }
    }

    public static void removePlayerTag(Player player, int tag) {
        removePlayerTag(player, tag + "");
    }

    public static void addPlayerTag(Player player, VexTag vexTag) {
        UUID uuid = player.getUniqueId();
        String uuidString = uuid.toString();
        List<VexTag> vexTagList;
        if(entityVexTag.containsKey(uuid)){
            vexTagList = entityVexTag.get(uuid);
        }else {
            vexTagList = new CopyOnWriteArrayList<>();
            entityVexTag.put(uuid, vexTagList);
        }
        vexTagList.add(vexTag);
        if(vexTag instanceof VexImageTag){
            VexImageTag vexImageTag = (VexImageTag) vexTag;
            EntityEffectsImageBeen entityEffectsImageBeen = new EntityEffectsImageBeen(uuidString, vexImageTag.getId(), vexImageTag.getUrl(), (float) vexImageTag.getX(), (float) vexImageTag.getY(), (float) vexImageTag.getZ(), 0, 0, 0, vexImageTag.getXs(), vexImageTag.getYs());
           // EntityEffectsImageBeen entityEffectsImageBeen = new EntityEffectsImageBeen(uuidString, vexImageTag.getId(), vexImageTag.getUrl(), (float) (vexImageTag.getX()-1.02), (float) (vexImageTag.getY()-1.02), (float) vexImageTag.getZ(), vexImageTag.getRotX(), vexImageTag.getRotZ(), vexImageTag.getRotY(), vexImageTag.getXs(), vexImageTag.getYs());
            UnrealCoreAPI.inst(player).getEntityEffectsHelper().addImage(entityEffectsImageBeen);
        }
        if(vexTag instanceof VexTextTag){
            VexTextTag vexTextTag = (VexTextTag) vexTag;
            List<String> strings = new ArrayList<>();
            strings.add(vexTextTag.getText());
            EntityEffectsTextBeen entityEffectsTextBeen = new EntityEffectsTextBeen(uuidString, "Default", strings, 0.2, true, (float) vexTextTag.getX(), (float) vexTextTag.getY(), (float) vexTextTag.getZ(), 0, 0, 0);
//            EntityEffectsTextBeen entityEffectsTextBeen = new EntityEffectsTextBeen(uuidString, "Default", strings, 0.2, vexTextTag.isBack(), (float) vexTextTag.getX(), (float) vexTextTag.getY(), (float) vexTextTag.getZ(), vexTextTag.getRotX(), vexTextTag.getRotY(), vexTextTag.getRotZ());

            UnrealCoreAPI.inst(player).getEntityEffectsHelper().addText(entityEffectsTextBeen);
        }
    }



    public static List<VexTag> getPlayerTags(Player player) {
        UUID uuid = player.getUniqueId();
        List<VexTag> vexTagList = new ArrayList<>();
        if(entityVexTag.containsKey(uuid)){
            vexTagList = entityVexTag.get(uuid);
        }
        return vexTagList;
    }


    //WorldTag
    //================================================================================//

    public static Map<World, List<VexTag>> worldVexTag = new ConcurrentHashMap<>();

    public static void addWorldTag(World world, VexTag vexTag) {

    }

    public static void removeWorldTag(World world, Object id){

    }

    public static void removeWorldTag(World world, int id){

    }

    public static void removeWorldTag(World world, String id) {

    }

    public static List<VexTag> getWorldTags(World world) {
        return worldVexTag.get(world);
    }

}
