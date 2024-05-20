package lk.vexview.gui.components;

import com.daxton.unrealcore.display.content.module.input.InputModule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VexTextField extends VexComponents implements HoverTextComponent {

    private int id;

    private int width;

    private int height;

    private int maxString;

    private String text;

    private InputModule inputModule;

    private VexHoverText hov;

    public VexTextField(int x, int y, int width, int height, int maxString, int id) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxString = maxString;
    }

    public VexTextField(int x, int y, int width, int height, int maxString, int id, String text) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxString = maxString;
        this.text = text;
    }

    public String getTypedText() {
        if(inputModule != null){
            return inputModule.getText();
        }
        return text;
    }

    @Override
    public void setHover(VexHoverText hov) {
        this.hov = hov;
    }
    @Override
    public void setHover(List<String> l) {
        this.hov = new VexHoverText(l);
    }


    public Object getID() {
        return id;
    }

}
