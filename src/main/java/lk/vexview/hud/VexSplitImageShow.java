package lk.vexview.hud;

import lk.vexview.gui.components.VexHoverText;
import lk.vexview.gui.components.expand.VexSplitImage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexSplitImageShow extends VexShow{

    private String url;

    private int w;

    private int h;

    private int xs;

    private int ys;

    private int u;

    private int v;

    private int uWidth;

    private int vHeight;

    private int realWidth;

    private int realHeight;

    public VexSplitImageShow(int id, int time, VexSplitImage vpn) {
        this.id = String.valueOf(id);
        this.time = time;
        this.url = vpn.getUrl();
        this.x = vpn.getX();
        this.y = vpn.getY();
        this.w = vpn.getW();
        this.h = vpn.getH();
        this.u = vpn.getU();
        this.v = vpn.getV();
        this.uWidth = vpn.getUWidth();
        this.vHeight = vpn.getVHeight();
        this.realWidth = vpn.getRealWidth();
        this.realHeight = vpn.getRealHeight();
    }

    public VexSplitImageShow(int id, String url, int x, int y, int realWidth, int realHeight, int xs, int ys, int time, int uWidth, int vHeight, int u, int v) {
        this.id = String.valueOf(id);
        this.url = url;
        this.x = x;
        this.y = y;
        this.w = xs;
        this.h = ys;
        this.xs = xs;
        this.ys = ys;
        this.u = u;
        this.v = v;
        this.uWidth = uWidth;
        this.vHeight = vHeight;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
    }

    public VexSplitImageShow(String id, int time, VexSplitImage vpn) {
        this.id = id;
        this.time = time;
        this.url = vpn.getUrl();
        this.x = vpn.getX();
        this.y = vpn.getY();
        this.w = vpn.getW();
        this.h = vpn.getH();
        this.u = vpn.getU();
        this.v = vpn.getV();
        this.uWidth = vpn.getUWidth();
        this.vHeight = vpn.getVHeight();
        this.realWidth = vpn.getRealWidth();
        this.realHeight = vpn.getRealHeight();
    }

    public VexSplitImageShow(String id, String url, int x, int y, int realWidth, int realHeight, int xs, int ys, int time, int uWidth, int vHeight, int u, int v) {
        this.id = id;
        this.url = url;
        this.x = x;
        this.y = y;
        this.w = xs;
        this.h = ys;
        this.xs = xs;
        this.ys = ys;
        this.u = u;
        this.v = v;
        this.uWidth = uWidth;
        this.vHeight = vHeight;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
    }

    public VexSplitImageShow(String id, String url, int x, int y, int z, int realWidth, int realHeight, int xs, int ys, int time, int uWidth, int vHeight, int u, int v) {
        this.id = id;
        this.time = time;
        this.url = url;
        this.x = x;
        this.y = y;
        this.w = xs;
        this.h = ys;
        this.xs = xs;
        this.ys = ys;
        this.u = u;
        this.v = v;
        this.uWidth = uWidth;
        this.vHeight = vHeight;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
    }

    public String getType() {
        return ":\u0003\u0016)0\u0017.\u0018<\u0004";
    }

}
