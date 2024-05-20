package lk.vexview.gui;


import com.daxton.unrealcore.application.base.StringUtil;
import com.daxton.unrealcore.application.base.YmlFileUtil;
import lk.vexview.Main;
import lk.vexview.additional.application.base.NumberUtil;
import lk.vexview.additional.application.base.VVImageUtil;
import lk.vexview.additional.display.module.VexFunctionButton;
import lk.vexview.additional.display.module.VexItem;
import lk.vexview.gui.components.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class VexGui {

    private String url;

    private int x;

    private int y;

    private int width;

    private int height;

    private boolean closable;

    private boolean loading;

    private List<VexComponents> vexComponents = new LinkedList<>();

    public VexGui(FileConfiguration fileConfiguration) {
        this.url = VVImageUtil.getImage(YmlFileUtil.getString(fileConfiguration, "gui", "gui.png"));
        this.x = YmlFileUtil.getInt(fileConfiguration, "x", -1);
        this.y = YmlFileUtil.getInt(fileConfiguration, "y", -1);
        this.width = YmlFileUtil.getInt(fileConfiguration, "width", 240);
        this.height = YmlFileUtil.getInt(fileConfiguration, "high", 158);

        fileConfiguration.getStringList("image").forEach(name->{
            FileConfiguration componentsYml = Main.unrealCorePlugin.getYmlFile("image/"+name+".yml");
            VexImage vexImage = new VexImage(StringUtil.generateRandomString(3), componentsYml);
            addComponent(vexImage);
        });
        fileConfiguration.getStringList("gifimage").forEach(name->{
            FileConfiguration componentsYml = Main.unrealCorePlugin.getYmlFile("gifimage/"+name+".yml");
            VexImage vexImage = new VexImage(StringUtil.generateRandomString(3), componentsYml);
            addComponent(vexImage);
        });
        fileConfiguration.getStringList("text").forEach(name->{
            FileConfiguration componentsYml = Main.unrealCorePlugin.getYmlFile("text/"+name+".yml");
            VexText vexText = new VexText(StringUtil.generateRandomString(3), componentsYml);
            addComponent(vexText);
        });
        fileConfiguration.getStringList("buttons").forEach(name->{
            FileConfiguration componentsYml = Main.unrealCorePlugin.getYmlFile("button/"+name+".yml");
            VexFunctionButton vexButton = new VexFunctionButton(StringUtil.generateRandomString(3), componentsYml);
            addComponent(vexButton);
        });
        fileConfiguration.getStringList("slot").forEach(name->{
            FileConfiguration componentsYml = Main.unrealCorePlugin.getYmlFile("slot/"+name+".yml");
            VexItem vexSlot = new VexItem(StringUtil.generateRandomString(3), componentsYml);

            addComponent(vexSlot);
        });


    }

    public VexGui(String url, int x, int y, int width, int height) {
        this.url = VVImageUtil.getImage(url);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public VexGui(String url, int x, int y, int width, int height, int xs, int ys) {
        this.url = VVImageUtil.getImage(url);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public VexGui(String url, int x, int y, int width, int height, int xs, int ys, List<VexComponents> lvc) {
        this.url = VVImageUtil.getImage(url);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vexComponents = lvc;
    }

    public VexGui(String url, int x, int y, int width, int height, List<VexComponents> lvc) {
        this.url = VVImageUtil.getImage(url);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vexComponents = lvc;
    }

    public int getPosition(){
        if(x == -1 && y == -1){
            return 5;
        }
        if(x == -1){
            return 2;
        }
        if(y == -1){
            return 4;
        }
        return 0;
    }

    public int getX(){
        if(x == -1){
            return 0;
        }
        return x;
    }

    public int getY(){
        if(y == -1){
            return 0;
        }
        return y;
    }

    public VexButton getButtonById(Object id) {
        if (id == null) {
            return null;
        }

        for (VexComponents component : vexComponents) {
            if(component instanceof  VexButton){
                VexButton vexButton = (VexButton) component;
                if(vexButton.getID().equals(id)){
                    return vexButton;
                }
            }

        }

        return null;
    }

    public List<VexComponents> getComponents() {
        return vexComponents;
    }

    public VexTextArea getTextArea(int a) {
        for (VexComponents component : vexComponents) {
            if(component instanceof VexTextArea){
                VexTextArea vexTextArea = (VexTextArea) component;
                if(vexTextArea.getId() == a){
                    return vexTextArea;
                }
            }
        }
        return null;
    }

    public VexTextField getTextField() {
        for (VexComponents component : vexComponents) {
            if(component instanceof VexTextField){
                return (VexTextField) component;
            }
        }
        return null;
    }

    public VexSlot getSlotById(int id) {

        for (VexComponents component : vexComponents) {
            if(component instanceof VexSlot){
                VexSlot vexSlot = (VexSlot) component;
                if(vexSlot.getID().toString().equals(String.valueOf(id))){
                    return vexSlot;
                }
            }

        }

        return null;
    }

    public VexScrollingList getList() {
        for (VexComponents component : vexComponents) {
            if(component instanceof VexScrollingList){
                return (VexScrollingList) component;
            }
        }
        return null;
    }

    public VexCheckBox getCheckBoxById(int id) {

        for (VexComponents component : vexComponents) {
            if(component instanceof VexCheckBox){
                VexCheckBox vexCheckBox = (VexCheckBox) component;
                if(vexCheckBox.getID().equals(id)){
                    return vexCheckBox;
                }
            }

        }

        return null;
    }

    public VexTextField getTextField(int id) {
        for (VexComponents component : vexComponents) {
            if(component instanceof VexTextField){
                VexTextField vexTextField = (VexTextField) component;
                if(vexTextField.getID().equals(id)){
                    return vexTextField;
                }
            }

        }

        return null;
    }

    public VexScrollingList getVexScrollingList(String id){
        for (VexComponents component : vexComponents) {
            if(component instanceof VexScrollingList){
                VexScrollingList vexScrollingList = (VexScrollingList) component;
                if(vexScrollingList.getId().equals(id)){
                    return vexScrollingList;
                }
            }

        }

        return null;
    }

    public VexGui clone() {
        VexGui vexGui = new VexGui(this.url, this.x, this.y, this.width, this.height, this.vexComponents);
        vexGui.setClosable(isClosable());

        return vexGui;
    }

    public void addComponent(VexComponents vexComponents) {
        this.vexComponents.add(0, vexComponents);
    }

    public void addAllComponents(List<VexComponents> vexComponents) {
        this.vexComponents.addAll(0, vexComponents);
    }

    public void isLoading(boolean loading){
        this.loading = loading;
    }


}
