package lk.vexview.hud;

import lk.vexview.gui.components.VexText;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
public class VexTextShow extends VexShow{

    private List<String> l = new LinkedList<>();

    private double scale;

    public VexTextShow(int id, int x, int y, List<String> l, int time) {
        this.id = id+"";
        this.x = x;
        this.y = y;
        this.l = l;
        this.time = time;
    }

    public VexTextShow(int id, VexText vt, int time) {
        this.id = id+"";
        this.x = vt.getX();
        this.y = vt.getY();
        this.l = vt.getL();
        this.time = time;
    }

    public VexTextShow(String id, int x, int y, int z, List<String> l, int time) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.l = l;
        this.time = time;
    }

    public VexTextShow(String id, int x, int y, int z, List<String> l, int time, double scale) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.l = l;
        this.time = time;
        this.scale = scale;
    }

    public VexTextShow(String id, int x, int y, List<String> l, int time) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.l = l;
        this.time = time;
    }

    public VexTextShow(String id, int x, int y, List<String> l, int time, double scale) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.l = l;
        this.time = time;
        this.scale = scale;
    }

    public VexTextShow(String id, VexText vt, int time) {
        this.id = id;
        this.x = vt.getX();
        this.y = vt.getY();
        this.l = vt.getL();
        this.time = time;
    }

    public VexTextShow(String id, VexText vt, int time, double scale) {
        this.id = id;
        this.x = vt.getX();
        this.y = vt.getY();
        this.l = vt.getL();
        this.time = time;
        this.scale = scale;
    }

    public String getType() {
        return "Q6H2";
    }

}
