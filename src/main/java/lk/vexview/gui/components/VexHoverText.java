package lk.vexview.gui.components;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class VexHoverText {

    private int x;

    private int y;

    private int w;

    private int h;

    private List<String> l;

    public VexHoverText(List<String> l) {
        this.l = l;
    }

    public VexHoverText( List<String> l, int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.l = l;
    }

}
