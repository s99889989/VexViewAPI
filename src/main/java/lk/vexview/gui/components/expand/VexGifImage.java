package lk.vexview.gui.components.expand;

import lk.vexview.gui.components.VexHoverText;
import lk.vexview.gui.components.VexImage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexGifImage extends VexImage {

    private int interval = 1;

    public VexGifImage(String url, int x, int y, int xs, int ys, int interval) {
        super(url, x, y, xs, ys);
        this.interval = interval;
    }

    public VexGifImage(String url, int x, int y, int w, int h, int xs, int ys) {
        super(url, x, y, w, h, xs, ys);
    }

    public VexGifImage(String url, int x, int y, int w, int h, int xs, int ys, int interval) {
        super(url, x, y, w, h, xs, ys);
        this.interval = interval;
    }

    public VexGifImage(String url, int x, int y, int w, int h, int xs, int ys, int interval, VexHoverText hov) {
        super(url, x, y, w, h, xs, ys, hov);
        this.interval = interval;
    }

    public VexGifImage(String url, int x, int y, int w, int h, int xs, int ys, VexHoverText hov) {
        super(url, x, y, w, h, xs, ys, hov);
    }
}
