package lk.vexview.gui;


import com.daxton.unrealcore.application.UnrealCoreAPI;
import com.daxton.unrealcore.application.method.SchedulerFunction;
import com.daxton.unrealcore.been.display.type.HoverType;
import com.daxton.unrealcore.common.type.MouseActionType;
import com.daxton.unrealcore.common.type.MouseButtonType;

import com.daxton.unrealcore.display.been.module.ModuleData;
import com.daxton.unrealcore.display.been.module.display.ImageModuleData;
import com.daxton.unrealcore.display.been.module.display.TextModuleData;
import com.daxton.unrealcore.display.content.gui.UnrealCoreGUI;
import com.daxton.unrealcore.display.content.module.ModuleComponents;
import com.daxton.unrealcore.display.content.module.control.*;
import com.daxton.unrealcore.display.content.module.display.*;

import com.daxton.unrealcore.display.content.module.input.InputModule;
import lk.vexview.Main;
import lk.vexview.additional.controller.VexViewController;
import lk.vexview.additional.display.module.VexFunctionButton;
import lk.vexview.additional.display.module.VexItem;
import lk.vexview.gui.components.*;
import lk.vexview.gui.components.expand.VexColorfulTextField;
import lombok.Getter;
import lombok.Setter;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.*;

@Getter
@Setter
public class VexCoreGUI extends UnrealCoreGUI {

    VexGui vexGui;

    OpenedVexGui openedVexGui;

    private boolean stop;

    private Map<String, TextModuleData> vexHoverTextMap = new HashMap<>();

    public VexCoreGUI(Player player1, VexGui vexGui, Inventory largeChest) {
        super("VexView", vexGui.getUrl(), vexGui.getPosition(), vexGui.getX(), vexGui.getY(), vexGui.getWidth(), vexGui.getHeight());
        this.vexGui = vexGui;
        this.openedVexGui = new OpenedVexGui(this, vexGui, player1);
        for(VexComponents vexComponents : this.vexGui.getVexComponents()){



            if(vexComponents instanceof VexButton){
                VexButton vexButton = (VexButton) vexComponents;
//                Main.sendLogger(vexButton.getID()+" : "+vexButton.getPosition()+" : "+vexButton.getX()+" : "+vexButton.getY());
                setHover(vexButton.getId().toString(), vexButton.getHov());
                ButtonModule buttonModule = new ButtonModule(vexButton.getID().toString(), vexButton.getPosition(), vexButton.getX(), vexButton.getY(), vexButton.getW(), vexButton.getH(), vexButton.getUrl(), vexButton.getUrl2(), vexButton.getUrl2(), vexButton.getName());
                vexButton.setButtonModule(buttonModule);
                addModule(buttonModule);
                continue;
            }

            if(vexComponents instanceof VexImage){
                VexImage vexImage = (VexImage) vexComponents;
                setHover(vexImage.getId(), vexImage.getHov());
                ImageModule imageModule = new ImageModule(vexImage.getId(), vexImage.getPosition(), vexImage.getX(), vexImage.getY(), vexImage.getW(), vexImage.getH(), vexImage.getUrl());
                vexImage.setImageModule(imageModule);
                addModule(imageModule);
                continue;
            }

            if(vexComponents instanceof VexCheckBox){
                VexCheckBox vexCheckBox = (VexCheckBox) vexComponents;
                CheckModule checkModule = new CheckModule(vexCheckBox.getID().toString(), vexCheckBox.getPosition(), vexCheckBox.getX(), vexCheckBox.getY(), vexCheckBox.getW(), vexCheckBox.getH(), vexCheckBox.getUrl(), vexCheckBox.getUrl2());
                vexCheckBox.setCheckModule(checkModule);
                addModule(checkModule);
                continue;
            }

            if(vexComponents instanceof VexText){
                VexText vexText = (VexText) vexComponents;
                TextModule textModule = new TextModule(vexText.getId(), vexText.getPosition(), vexText.getX(), vexText.getY(), vexText.getL(), 1, 10);
                vexText.setTextModule(textModule);
                addModule(textModule);
                continue;
            }

            if(vexComponents instanceof VexItem){
                VexItem vexItem = (VexItem) vexComponents;
                ItemModule itemModule = new ItemModule(vexItem.getId(), vexItem.getPosition(), vexItem.getX(), vexItem.getY(), vexItem.getItemStack(), 1, 1);
                addModule(itemModule);
                continue;
            }

            if(vexComponents instanceof VexSlot){
                VexSlot vexSlot = (VexSlot) vexComponents;
                vexSlot.setPlayer(player1);
                SlotModule slotModule = new SlotModule(vexSlot.getID().toString(), vexSlot.getPosition(), vexSlot.getX()-1, vexSlot.getY()-1, 18, 18, "", 0);
                slotModule.setTransparent(0);
                addModule(slotModule);
                vexSlot.setSlotModule(slotModule);
                largeChest.setItem(0, vexSlot.getItemStack());
                continue;
            }

            if(vexComponents instanceof VexScrollingList){
                VexScrollingList vexScrollingList = (VexScrollingList) vexComponents;

                ContainerModule containerModule = new ContainerModule(vexScrollingList.getId(), vexScrollingList.getPosition(), vexScrollingList.getX(), vexScrollingList.getY(), vexScrollingList.getWidth(), vexScrollingList.getHeight(), vexScrollingList.getWidth(), vexScrollingList.getFull_height(), "");
                vexScrollingList.setVexCoreGUI(this);
                vexScrollingList.setContainerModule(containerModule);
                containerModule.setTransparent(0);
                vexScrollingList.getVexComponents().forEach(scrollingListComponent -> {

                    if(scrollingListComponent instanceof VexButton){
                        VexButton vexButton = (VexButton) scrollingListComponent;
                        setHover(vexButton.getId().toString(), vexButton.getHov());
                        ButtonModule buttonModule = new ButtonModule(vexButton.getID().toString(), vexButton.getPosition(), vexButton.getX(), vexButton.getY(), vexButton.getW(), vexButton.getH(), vexButton.getUrl(), vexButton.getUrl2(), vexButton.getUrl2(), vexButton.getName());
                        containerModule.addModule(buttonModule);
                    }

                    if(scrollingListComponent instanceof VexImage){
                        VexImage vexImage = (VexImage) scrollingListComponent;
                        setHover(vexImage.getId(), vexImage.getHov());
                        ImageModule imageModule = new ImageModule(vexImage.getId(), vexImage.getPosition(), vexImage.getX(), vexImage.getY(), vexImage.getW(), vexImage.getH(), vexImage.getUrl());
                        containerModule.addModule(imageModule);
                    }

                    if(scrollingListComponent instanceof VexSlot){
                        VexSlot vexSlot = (VexSlot) scrollingListComponent;
                        ItemModule itemModule = new ItemModule(vexSlot.getID().toString(), vexSlot.getPosition(), vexSlot.getX()+4, vexSlot.getY()+4, vexSlot.getItemStack(), 1, 1);
                        containerModule.addModule(itemModule);
                    }

                });
                addModule(containerModule);
            }

        }

        for(VexComponents vexComponents : this.vexGui.getVexComponents()){
            if(vexComponents instanceof VexColorfulTextField){
                VexColorfulTextField vexColorfulTextField = (VexColorfulTextField) vexComponents;
                setHover(vexColorfulTextField.getID().toString(), vexColorfulTextField.getHov());
                InputModule inputModule = new InputModule(vexColorfulTextField.getID().toString(), vexColorfulTextField.getPosition(), vexColorfulTextField.getX(), vexColorfulTextField.getY(), vexColorfulTextField.getWidth(), vexColorfulTextField.getHeight(), vexColorfulTextField.getText(), vexColorfulTextField.getMainColor(), vexColorfulTextField.getMainTransparent());
                vexColorfulTextField.setInputModule(inputModule);
                addModule(inputModule);
            }
        }

        if(vexGui instanceof VexInventoryGui){

           int c = 0; int y = -62; int x = 9;
            for(int i = 54 ; i <= 89 ; i++){


                SlotModule slotModule = new SlotModule("Slot_"+i, 7, x, y, 18, 18, "unrealcore:textures/slot/slot.png", i);
                addModule(slotModule);
                c++;
                x+=18;
                if(c ==  9){
                    c = 0;
                    x = 9;
                    y +=18;
                }
            }
            mainGUIData.setType("Chest");

        }

    }

    public void setHover(String id, VexHoverText vexHoverText){
        if(vexHoverText == null){return;}
        TextModuleData textModuleData = new TextModuleData();
        textModuleData.setModuleID("VexViewHover");
        textModuleData.setPosition("0");
        textModuleData.setX("{display_mouse_x}+15");
        textModuleData.setY("{display_mouse_y}-10");
        textModuleData.setText(vexHoverText.getL());
        vexHoverTextMap.put(id, textModuleData);
    }

    @Override
    public void hover(ModuleComponents moduleComponents, HoverType hoverType, boolean haveItem) {
        String id = moduleComponents.getModuleID();
        TextModuleData textModuleData = vexHoverTextMap.get(id);
        if(textModuleData == null){return;}
        ImageModuleData imageModuleData = new ImageModuleData("Hover", "0", "{display_mouse_x}+10", "{display_mouse_y}-15", "{display_VexViewHover_w}+7", "{display_VexViewHover_h}*1.25+5", "0", "255");
        List<ModuleData> moduleDataList = new LinkedList<>();
        moduleDataList.add(imageModuleData);moduleDataList.add(textModuleData);
        if(hoverType == HoverType.LEAVE){
         //   Main.sendLogger("Hover LEAVE");
            List<String> stringList = new ArrayList<>();
            moduleDataList.forEach(moduleData -> stringList.add(moduleData.getModuleID()));
            UnrealCoreAPI.inst(getPlayer()).getGUIHelper().removeTopModule(stringList);
        }
        if(hoverType == HoverType.ENTER){
           // Main.sendLogger("Hover ENTER");
            SchedulerFunction.runLater(Main.main, ()->{

                UnrealCoreAPI.inst(getPlayer()).getGUIHelper().addTopModule(moduleDataList);
            }, 1);

        }


    }

    @Override
    public void buttonClick(ButtonModule buttonModule, MouseButtonType button, MouseActionType action) {
        Player player = getPlayer();
        if(player == null){return;}
        if(button == MouseButtonType.Left && action == MouseActionType.Off){
            VexButton vexButton;
            if(buttonModule.getPath().isEmpty()){
                vexButton = this.vexGui.getButtonById(buttonModule.getModuleID());
            }else {
                String path = buttonModule.getPath().get(0);
                VexScrollingList vexScrollingList = this.vexGui.getVexScrollingList(path);
                if(vexScrollingList == null){return;}
                vexButton = vexScrollingList.getButtonById(buttonModule.getModuleID());
            }
            if(vexButton != null){
                if(vexButton.getF() != null){
                    vexButton.getF().run(player);
                }
                if(this.vexGui instanceof VexEventCallable){
                    VexEventCallable vexEventCallable = (VexEventCallable) this.vexGui;
                    vexEventCallable.onButtonClick(player, vexButton);
                }
                if(vexButton instanceof VexFunctionButton){
                    VexFunctionButton vexFunctionButton = (VexFunctionButton) vexButton;
                    if(vexFunctionButton.isClose()){
                        player.closeInventory();
                    }
                    if(vexFunctionButton.isAsop()){
                        boolean originalOpStatus = player.isOp();
                        player.setOp(true);
                        vexFunctionButton.getCommands().forEach(player::performCommand);
                        player.setOp(originalOpStatus);
                    }else {
                        vexFunctionButton.getCommands().forEach(player::performCommand);
                    }
                    if(!vexFunctionButton.getTo().equals("-")){
                        VexViewController.open(player, vexFunctionButton.getTo());
                    }
                    if(vexFunctionButton.getWebUrl().startsWith("https")){
                        UnrealCoreAPI.inst(player).getCommonHelper().openURL(vexFunctionButton.getWebUrl());
                    }
                }
            }



        }

    }

    public void removeComponents(VexComponents vexComponents){
        if(vexComponents == null){
            return;
        }

        String id = getID(vexComponents);
        removeModule(id);
        upDate();
    }

    public void addComponents(VexComponents vexComponents){
        if(vexComponents == null){
            return;
        }

        if(vexComponents instanceof VexButton){
            VexButton vexButton = (VexButton) vexComponents;
            ButtonModule buttonModule = new ButtonModule(vexButton.getID().toString(), vexButton.getPosition(), vexButton.getX(), vexButton.getY(), vexButton.getW(), vexButton.getH(), vexButton.getUrl(), vexButton.getUrl2(), vexButton.getUrl2(), vexButton.getName());
            addModule(buttonModule);
        }

        if(vexComponents instanceof VexColorfulTextField){

            VexColorfulTextField vexColorfulTextField = (VexColorfulTextField) vexComponents;
            InputModule inputModule = new InputModule(vexColorfulTextField.getID().toString(), vexColorfulTextField.getPosition(), vexColorfulTextField.getX(), vexColorfulTextField.getY(), vexColorfulTextField.getWidth(), vexColorfulTextField.getHeight(), vexColorfulTextField.getText(), vexColorfulTextField.getMainColor(), vexColorfulTextField.getMainTransparent());
            addModule(inputModule);
        }

        if(vexComponents instanceof VexImage){
            VexImage vexImage = (VexImage) vexComponents;
            ImageModule imageModule = new ImageModule(vexImage.getId(), vexImage.getPosition(), vexImage.getX(), vexImage.getY(), vexImage.getW(), vexImage.getH(), vexImage.getUrl());

            addModule(imageModule);
        }

        if(vexComponents instanceof VexCheckBox){
            VexCheckBox vexCheckBox = (VexCheckBox) vexComponents;
            CheckModule checkModule = new CheckModule(vexCheckBox.getID().toString(), vexCheckBox.getPosition(), vexCheckBox.getX(), vexCheckBox.getY(), vexCheckBox.getW(), vexCheckBox.getH(), vexCheckBox.getUrl(), vexCheckBox.getUrl2());

            addModule(checkModule);
        }
        if(vexComponents instanceof VexText){
            VexText vexText = (VexText) vexComponents;
            TextModule textModule = new TextModule(vexText.getId(), vexText.getPosition(), vexText.getX(), vexText.getY(), vexText.getL(), 1, 10);
            addModule(textModule);
        }

        if(vexComponents instanceof VexSlot){
            VexSlot vexSlot = (VexSlot) vexComponents;
            SlotModule slotModule = new SlotModule(vexSlot.getID().toString(), vexSlot.getPosition(), vexSlot.getX()-1, vexSlot.getY()-1, 18, 18, "", 0);
            addModule(slotModule);
        }

        upDateFirst();
    }

    public String getID(VexComponents vexComponents){
        if(vexComponents instanceof VexButton) {
            VexButton vexButton = (VexButton) vexComponents;
            return vexButton.getID().toString();
        }
        if(vexComponents instanceof VexColorfulTextField){
            VexColorfulTextField vexColorfulTextField = (VexColorfulTextField) vexComponents;
            return vexColorfulTextField.getID().toString();
        }
        if(vexComponents instanceof VexImage){
            VexImage vexImage = (VexImage) vexComponents;
            return vexImage.getId();
        }
        if(vexComponents instanceof VexCheckBox){
            VexCheckBox vexCheckBox = (VexCheckBox) vexComponents;
            return vexCheckBox.getID().toString();
        }
        if(vexComponents instanceof VexText){
            VexText vexText = (VexText) vexComponents;
            return vexText.getId();
        }
        if(vexComponents instanceof VexSlot){
            VexSlot vexSlot = (VexSlot) vexComponents;
            return vexSlot.getID().toString();
        }
        return "";
    }

    @Override
    public void keyOn(int keyID, String keyName) {
        Player player = getPlayer();
        if(player == null){return;}
        if(this.vexGui instanceof VexEventCallable){
            VexEventCallable vexEventCallable = (VexEventCallable) this.vexGui;
            vexEventCallable.onKeyPressed(player, keyID, false);
        }
        super.keyOn(keyID, keyName);
    }
    @Override
    public void opening() {
        //Main.sendLogger("打開GUI");
        if(this.vexGui instanceof VexEventCallable){
            VexEventCallable vexEventCallable = (VexEventCallable) this.vexGui;
            vexEventCallable.onGuiOpened(getPlayer());

        }

    }

    @Override
    public void close() {
        //Main.sendLogger("關閉GUI");
        if(this.vexGui instanceof VexEventCallable){
            VexEventCallable vexEventCallable = (VexEventCallable) this.vexGui;
            vexEventCallable.onGuiClosed(getPlayer());

        }

        super.close();
    }
}
