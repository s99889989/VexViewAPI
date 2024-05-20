package lk.vexview.gui.components.expand;

import lk.vexview.gui.components.VexHoverText;
import lk.vexview.gui.components.VexImage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexSplitImage extends VexImage {

    private int u;

    private int v;

    private int uWidth;

    private int vHeight;

    private int realWidth;

    private int realHeight;

    public VexSplitImage(String url, int x, int y, int u, int v, int xs, int ys, int uWidth, int vHeight, int realWidth, int realHeight) {
        super(url, x, y, xs, ys);
        this.u = u;
        this.v = v;
        this.uWidth = uWidth;
        this.vHeight = vHeight;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
    }

    public VexSplitImage(String url, int x, int y, int u, int v, int xs, int ys, int uWidth, int vHeight, int realWidth, int realHeight, VexHoverText hov) {
        super(url, x, y, xs, ys, hov);
        this.u = u;
        this.v = v;
        this.uWidth = uWidth;
        this.vHeight = vHeight;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
    }


    public String getType() {
        return "\u0016/(\u00179\u001e&\u0010.\u0016";
    }

}
