package lk.vexview.additional.gui;

import com.daxton.unrealcore.display.been.module.display.TextModuleData;
import com.daxton.unrealcore.display.content.gui.UnrealCoreGUI;
import com.daxton.unrealcore.display.content.module.control.ButtonModule;
import com.daxton.unrealcore.display.content.module.control.CheckModule;
import com.daxton.unrealcore.display.content.module.control.ContainerModule;
import com.daxton.unrealcore.display.content.module.control.SlotModule;
import com.daxton.unrealcore.display.content.module.display.ImageModule;
import com.daxton.unrealcore.display.content.module.display.ItemModule;
import com.daxton.unrealcore.display.content.module.display.TextModule;
import com.daxton.unrealcore.display.content.module.input.InputModule;
import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.*;
import lk.vexview.gui.components.expand.VexColorfulTextField;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class UnrealGUIContainer extends UnrealCoreGUI {

    private VexGui vexGui;

    private Map<String, TextModuleData> vexHoverTextMap = new HashMap<>();

    public UnrealGUIContainer(Player player1, String guiName, VexGui vexGui) {
        super(guiName, vexGui.getUrl(), vexGui.getPosition(), vexGui.getX(), vexGui.getY(), vexGui.getWidth(), vexGui.getHeight());
        this.vexGui = vexGui;

        this.vexGui.getVexComponents().forEach(vexComponents -> {
            if(vexComponents instanceof VexButton){
                VexButton vexButton = (VexButton) vexComponents;
//                Main.sendLogger(vexButton.getID()+" : "+vexButton.getPosition()+" : "+vexButton.getX()+" : "+vexButton.getY());
                setHover(vexButton.getId().toString(), vexButton.getHov());
                ButtonModule buttonModule = new ButtonModule(vexButton.getID().toString(), vexButton.getPosition(), vexButton.getX(), vexButton.getY(), vexButton.getW(), vexButton.getH(), vexButton.getUrl(), vexButton.getUrl2(), vexButton.getUrl2(), vexButton.getName());
                vexButton.setButtonModule(buttonModule);
                addModule(buttonModule);
            }

            if(vexComponents instanceof VexImage){
                VexImage vexImage = (VexImage) vexComponents;
//                Main.sendLogger(vexImage.getId()+" : "+vexImage.getPosition()+" : "+vexImage.getX()+" : "+vexImage.getY());
                setHover(vexImage.getId(), vexImage.getHov());
                ImageModule imageModule = new ImageModule(vexImage.getId(), vexImage.getPosition(), vexImage.getX(), vexImage.getY(), vexImage.getW(), vexImage.getH(), vexImage.getUrl());
                vexImage.setImageModule(imageModule);
                addModule(imageModule);
            }

            if(vexComponents instanceof VexCheckBox){
                VexCheckBox vexCheckBox = (VexCheckBox) vexComponents;
                CheckModule checkModule = new CheckModule(vexCheckBox.getID().toString(), vexCheckBox.getPosition(), vexCheckBox.getX(), vexCheckBox.getY(), vexCheckBox.getW(), vexCheckBox.getH(), vexCheckBox.getUrl(), vexCheckBox.getUrl2());
                vexCheckBox.setCheckModule(checkModule);
                addModule(checkModule);
            }

            if(vexComponents instanceof VexText){
                VexText vexText = (VexText) vexComponents;
                TextModule textModule = new TextModule(vexText.getId(), vexText.getPosition(), vexText.getX(), vexText.getY(), vexText.getL(), 1, 10);
                vexText.setTextModule(textModule);
                addModule(textModule);
            }

            if(vexComponents instanceof VexSlot){
                VexSlot vexSlot = (VexSlot) vexComponents;
                vexSlot.setPlayer(player1);
                SlotModule slotModule = new SlotModule(vexSlot.getID().toString(), vexSlot.getPosition(), vexSlot.getX()-1, vexSlot.getY()-1, 18, 18, "", 0);
                slotModule.setTransparent(0);
                addModule(slotModule);
                vexSlot.setSlotModule(slotModule);
            }

            if(vexComponents instanceof VexScrollingList){
                VexScrollingList vexScrollingList = (VexScrollingList) vexComponents;

                ContainerModule containerModule = new ContainerModule(vexScrollingList.getId(), vexScrollingList.getPosition(), vexScrollingList.getX(), vexScrollingList.getY(), vexScrollingList.getWidth(), vexScrollingList.getHeight(), vexScrollingList.getWidth(), vexScrollingList.getFull_height(), "");

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

        });

        this.vexGui.getVexComponents().forEach(vexComponents -> {


            if(vexComponents instanceof VexColorfulTextField){

                VexColorfulTextField vexColorfulTextField = (VexColorfulTextField) vexComponents;
                InputModule inputModule = new InputModule(vexColorfulTextField.getID().toString(), vexColorfulTextField.getPosition(), vexColorfulTextField.getX(), vexColorfulTextField.getY(), vexColorfulTextField.getWidth(), vexColorfulTextField.getHeight(), vexColorfulTextField.getText(), vexColorfulTextField.getMainColor(), vexColorfulTextField.getMainTransparent());
                vexColorfulTextField.setInputModule(inputModule);
                addModule(inputModule);
            }

        });

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

}
