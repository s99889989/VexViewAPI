package lk.vexview.gui.components.expand;

import lk.vexview.gui.components.VexTextArea;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class VexColorfulTextArea extends VexTextArea {

    private int main_color;

    private int side_color;

    public VexColorfulTextArea(int x, int y, int width, int height, int maxString, int id, int main_color, int side_color) {
        super(x, y, width, height, maxString, id);
        this.main_color = main_color;
        this.side_color = side_color;
    }

    public VexColorfulTextArea(int x, int y, int width, int height, int maxString, int id, int main_color, int side_color, List<String> text) {
        super(x, y, width, height, maxString, id, text);
        this.main_color = main_color;
        this.side_color = side_color;
    }

}
