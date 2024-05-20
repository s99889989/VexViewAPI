package lk.vexview.gui;

public class VexInventoryGui extends VexGui{

    private int xs;

    private int ys;

    private int slotLeft;

    private int slotTop;

    public VexInventoryGui(String gui, int x, int y, int width, int height, int xs, int ys, int slotLeft, int slotTop) {
        super(gui, x, y, width, height);
        this.xs = xs;
        this.ys = ys;
        this.slotLeft = slotLeft;
        this.slotTop = slotTop;
    }

}
