package lk.vexview.gui;

import lk.vexview.Main;
import lk.vexview.gui.components.*;
import org.bukkit.entity.Player;

public class OpenedVexGui {

    VexCoreGUI vexCoreGUI;

    VexGui vexGui;

    Player player;

    public OpenedVexGui(VexCoreGUI vexCoreGUI, VexGui vexGui, Player player) {
        this.vexCoreGUI = vexCoreGUI;
        this.vexGui = vexGui;
        this.player = player;
    }

    public void removeDynamicComponent(DynamicComponent dynamicComponent) {
        if(dynamicComponent == null){return;}
        if(!(dynamicComponent instanceof VexComponents)){return;}
        VexComponents vexComponents = (VexComponents) dynamicComponent;
        if(this.vexGui != null){
            this.vexGui.getVexComponents().remove(vexComponents);
        }
        if(this.vexCoreGUI != null){
            this.vexCoreGUI.removeComponents(vexComponents);
        }

    }

    public void addDynamicComponent(DynamicComponent dynamicComponent) {
        if(dynamicComponent == null){return;}
        if(!(dynamicComponent instanceof VexComponents)){return;}
        VexComponents vexComponents = (VexComponents) dynamicComponent;
        if(this.vexGui != null){
            this.vexGui.addComponent(vexComponents);
        }
        if(this.vexCoreGUI != null){
            this.vexCoreGUI.addComponents(vexComponents);
        }
    }

    public void setTextFieldContent(int id, String text) {
        if(this.vexGui == null){return;}
        VexTextField vexTextField = this.vexGui.getTextField(id);
        if(vexTextField == null){return;}
        vexTextField.setText(text);
    }

    public void setCheckBox(int id, boolean enable) {
       if(this.vexGui == null){return;}
        VexCheckBox vexCheckBox = this.vexGui.getCheckBoxById(id);
       if(vexCheckBox == null){return;}
       vexCheckBox.setChecked(enable);
    }

    public VexGui getVexGui() {
        return this.vexGui;
    }

}
