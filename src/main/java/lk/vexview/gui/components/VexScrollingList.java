package lk.vexview.gui.components;

import com.daxton.unrealcore.application.base.StringUtil;
import com.daxton.unrealcore.display.content.module.control.ButtonModule;
import com.daxton.unrealcore.display.content.module.control.ContainerModule;
import com.daxton.unrealcore.display.content.module.display.ImageModule;
import com.daxton.unrealcore.display.content.module.display.ItemModule;
import lk.vexview.gui.VexCoreGUI;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class VexScrollingList extends VexComponents implements DynamicComponent {

    private String id;

    private int width;

    private int height;

    private int full_height;

    private boolean defaultPosition;

    private List<ScrollingListComponent> vexComponents = new LinkedList<>();

    private VexCoreGUI vexCoreGUI;

    private ContainerModule containerModule;

    public VexScrollingList(int x, int y, int width, int height, int full_height) {
        this.id = StringUtil.generateRandomString(3);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.full_height = full_height;
    }

    public void addComponent(ScrollingListComponent scrollingListComponent) {
        vexComponents.add(scrollingListComponent);

        if(vexCoreGUI == null){return;}
        if(scrollingListComponent instanceof VexButton){
            VexButton vexButton = (VexButton) scrollingListComponent;
            vexCoreGUI.setHover(vexButton.getId().toString(), vexButton.getHov());
            ButtonModule buttonModule = new ButtonModule(vexButton.getID().toString(), 1, vexButton.getX(), vexButton.getH(), vexButton.getW(), vexButton.getH(), vexButton.getUrl(), vexButton.getUrl2(), vexButton.getUrl2(), vexButton.getName());
            containerModule.addModule(buttonModule);
        }

        if(scrollingListComponent instanceof VexImage){
            VexImage vexImage = (VexImage) scrollingListComponent;
            vexCoreGUI.setHover(vexImage.getId(), vexImage.getHov());
            ImageModule imageModule = new ImageModule(vexImage.getId(), 1, vexImage.getX(), vexImage.getH(), vexImage.getW(), vexImage.getH(), vexImage.getUrl());
            containerModule.addModule(imageModule);
        }

        if(scrollingListComponent instanceof VexSlot){
            VexSlot vexSlot = (VexSlot) scrollingListComponent;
            ItemModule itemModule = new ItemModule(vexSlot.getID().toString(), 1, vexSlot.getX()+4, vexSlot.getY()+4, vexSlot.getItemStack(), 1, 1);
            containerModule.addModule(itemModule);
        }
        vexCoreGUI.upDate();
    }

    public VexButton getButtonById(Object id) {
        if (id == null) {
            return null;
        }

        for (ScrollingListComponent component : vexComponents) {
            if(component instanceof  VexButton){
                VexButton vexButton = (VexButton) component;
                if(vexButton.getID().equals(id)){
                    return vexButton;
                }
            }

        }

        return null;
    }

    public int getFullHeight() {
        return full_height;
    }

    public String getType() {
        return "ZiBs";
    }

}
