package lk.vexview.tag.components;

import lk.vexview.tag.TagDirection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexMcImageTag extends VexSpiltImageTag{


    public VexMcImageTag(String id, String url, double x, double y, double z, int realWidth, int realHeight, float xs, float ys, int uWidth, int vHeight, int u, int v, TagDirection td) {
        super(id, url, x, y, z, realWidth, realHeight, xs, ys, uWidth, vHeight, u, v, td);
    }


}
