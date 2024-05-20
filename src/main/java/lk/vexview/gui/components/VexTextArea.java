package lk.vexview.gui.components;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VexTextArea extends VexComponents implements HoverTextComponent {

    private int width;

    private int height;

    private int maxString;

    private int id;

    private List<String> text;

    private VexHoverText hov;

    private int main_color;

    private int side_color;

    public VexTextArea(int x, int y, int width, int height, int maxString, int id) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxString = maxString;
        this.id = id;
    }

    public VexTextArea(int x, int y, int width, int height, int maxString, int id, List<String> text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxString = maxString;
        this.id = id;
        this.text = text;
    }

    @Override
    public void setHover(VexHoverText hov) {
        this.hov = hov;
    }
    @Override
    public void setHover(List<String> l) {
        this.hov = new VexHoverText(l);
    }

    public String getType() {
        return "b%]\u0007S\u0016S\u0001";
    }

}
