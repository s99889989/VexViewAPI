package lk.vexview.gui.components.expand;

import com.daxton.unrealcore.application.base.InputStreamUtil;
import lk.vexview.gui.components.HoverTextComponent;
import lk.vexview.gui.components.VexComponents;
import lk.vexview.gui.components.VexHoverText;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.InputStream;
import java.util.List;

@Getter
@Setter
@ToString
public class VexBase64Image extends VexComponents implements HoverTextComponent {

    private String id;

    private byte[] base64;

    private int w;

    private int h;

    private VexHoverText hov;

    public VexBase64Image(InputStream image, int id, int x, int y, int w, int h) {
        this.id = String.valueOf(id);
        this.base64 = InputStreamUtil.toBase64Empty(image);
        this.w = w;
        this.h = h;
    }

    public VexBase64Image(InputStream image, int id, int x, int y, int w, int h, VexHoverText hov) {
        this.id = String.valueOf(id);
        this.base64 = InputStreamUtil.toBase64Empty(image);
        this.w = w;
        this.h = h;
        this.hov = hov;
    }

    public VexBase64Image(InputStream image, String id, int x, int y, int w, int h) {
        this.id = id;
        this.base64 = InputStreamUtil.toBase64Empty(image);
        this.w = w;
        this.h = h;
    }

    public VexBase64Image(InputStream image, String id, int x, int y, int w, int h, VexHoverText hov) {
        this.id = id;
        this.base64 = InputStreamUtil.toBase64Empty(image);
        this.w = w;
        this.h = h;
        this.hov = hov;
    }

    public VexHoverText getHover(){
        return this.hov;
    }

    @Override
    public void setHover(VexHoverText hov) {
        this.hov = hov;
    }
    @Override
    public void setHover(List<String> l) {
        this.hov = new VexHoverText(l);
    }

}
