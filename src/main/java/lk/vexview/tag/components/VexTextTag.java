package lk.vexview.tag.components;

import lk.vexview.tag.TagDirection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexTextTag extends VexTag{

    private String text;

    private boolean back;

    public VexTextTag(String id, double x, double y, double z, String text, boolean back, TagDirection tagDirection) {
        super(x, y, z, tagDirection, id, "9\u00123\u0005");
        this.text = text;
        this.back = back;
    }

    public VexTextTag(Object id, double x, double y, double z, String text, boolean back, TagDirection tagDirection) {
        super(x, y, z, tagDirection, id.toString(), "9\u00123\u0005");
        this.text = text;
        this.back = back;
    }

    public VexTextTag(int id, double x, double y, double z, String text, boolean back, TagDirection tagDirection) {
        super(x, y, z, tagDirection, id+"", "9\u00123\u0005");
        this.text = text;
        this.back = back;
    }

}
