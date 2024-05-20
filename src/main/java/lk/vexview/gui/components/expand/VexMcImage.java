package lk.vexview.gui.components.expand;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexMcImage extends VexSplitImage{


    public VexMcImage(String url, int x, int y, int u, int v, int xs, int ys, int uWidth, int vHeight, int realWidth, int realHeight) {
        super(url, x, y, u, v, xs, ys, uWidth, vHeight, realWidth, realHeight);
    }

    public String getType() {
        return "mcimage";
    }

}
