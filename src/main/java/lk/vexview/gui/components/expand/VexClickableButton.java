package lk.vexview.gui.components.expand;

import lk.vexview.gui.components.ButtonFunction;
import lk.vexview.gui.components.VexButton;
import lk.vexview.gui.components.VexHoverText;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexClickableButton extends VexButton {

    private boolean clickable;

    private String url3;

    public VexClickableButton(int id, String name, String url, String url2, String url3, int x, int y, int w, int h, boolean clickable) {
        super(id, name, url, url2, x, y, w, h);
        this.url3 =  url3;
        this.clickable = clickable;
    }

    public VexClickableButton(int id, String name, String url, String url2, String url3, int x, int y, int w, int h, ButtonFunction f, boolean clickable) {
        super(id, name, url, url2, x, y, w, h, f);
        this.url3 =  url3;
        this.clickable = clickable;
    }

    public VexClickableButton(int id, String name, String url, String url2, String url3, int x, int y, int w, int h, ButtonFunction f, VexHoverText hov, boolean clickable) {
        super(id, name, url, url2, x, y, w, h, f, hov);
        this.url3 =  url3;
        this.clickable = clickable;
    }

    public VexClickableButton(int id, String name, String url, String url2, String url3, int x, int y, int w, int h, VexHoverText hov, boolean clickable) {
        super(id, name, url, url2, x, y, w, h, hov);
        this.url3 =  url3;
        this.clickable = clickable;
    }

    public VexClickableButton(Object id, String name, String url, String url2, String url3, int x, int y, int w, int h, boolean clickable) {
        super(id, name, url, url2, x, y, w, h);
        this.url3 =  url3;
        this.clickable = clickable;
    }

    public VexClickableButton(Object id, String name, String url, String url2, String url3, int x, int y, int w, int h, ButtonFunction f, boolean clickable) {
        super(id, name, url, url2, x, y, w, h, f);
        this.url3 =  url3;
        this.clickable = clickable;
    }


}
