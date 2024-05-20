package lk.vexview.hud;

import lk.vexview.gui.components.expand.VexSplitImage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexMcImageShow extends VexSplitImageShow{


    public VexMcImageShow(int id, String url, int x, int y, int realWidth, int realHeight, int xs, int ys, int time, int uWidth, int vHeight, int u, int v) {
        super(id, url, x, y, realWidth, realHeight, xs, ys, time, uWidth, vHeight, u, v);
    }

    public VexMcImageShow(int id, String url, int x, int y, int z, int realWidth, int realHeight, int xs, int ys, int time, int uWidth, int vHeight, int u, int v) {
        super(id, url, x, y, realWidth, realHeight, xs, ys, time, uWidth, vHeight, u, v);
        this.z = z;
    }

    public String getType() {
        return "mcimage";
    }

}
