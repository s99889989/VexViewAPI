package lk.vexview.tag.components;

import lk.vexview.gui.components.VexEntityDraw;
import lk.vexview.tag.TagDirection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexEntityDrawTag extends VexTag{

    private VexEntityDraw entityDraw;


    public VexEntityDrawTag(double x, double y, double z, TagDirection tagDirection, String id, VexEntityDraw entityDraw) {
        super(x, y, z, tagDirection, id, "\u0006v\u0010v\u0017a\u001awU8");
        this.entityDraw = entityDraw;
    }

}
