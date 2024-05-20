package lk.vexview.hud;

import lk.vexview.gui.components.VexImage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexImageShow extends VexShow{

    private String url;

    private int w;

    private int h;

    private int xs;

    private int ys;

    public VexImageShow(int id, String url, int x, int y, int w, int h, int xs, int ys, int time) {
        this.id = String.valueOf(id);
        this.url = url;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xs = xs;
        this.ys = ys;
        this.time = time;
    }

    public VexImageShow(int id, VexImage vi, int time) {
        this.id = String.valueOf(id);
        this.url = vi.getUrl();
        this.x = vi.getX();
        this.y = vi.getY();
        this.w = vi.getW();
        this.h = vi.getH();
        this.xs = vi.getXs();
        this.ys = vi.getYs();
        this.time = time;
    }

    public VexImageShow(String id, String url, int x, int y, int w, int h, int xs, int ys, int time) {
        this.id = id;
        this.url = url;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xs = xs;
        this.ys = ys;
        this.time = time;
    }

    public VexImageShow(String id, String url, int x, int y, int z, int w, int h, int xs, int ys, int time) {
        this.id = id;
        this.url = url;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xs = xs;
        this.ys = ys;
        this.z = z;
        this.time = time;
    }

    public VexImageShow(String id, VexImage vi, int time) {
        this.id = id;
        this.url = vi.getUrl();
        this.x = vi.getX();
        this.y = vi.getY();
        this.w = vi.getW();
        this.h = vi.getH();
        this.xs = vi.getXs();
        this.ys = vi.getYs();
        this.time = time;
    }

    public int getWidth(){
        return this.w;
    }

    public int getHeight(){
        return this.h;
    }

    public VexImage getImage(){
        return new VexImage(this.url, this.x, this.y, this.w, this.h, this.xs, this.ys);
    }


    public String getType() {
        return "\u0000U\u000fG\u0013";
    }

}
