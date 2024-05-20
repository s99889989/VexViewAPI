package lk.vexview.hud;

import lk.vexview.gui.components.VexEntityDraw;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexEntityDrawShow extends VexShow{

    VexEntityDraw entityDraw;

    boolean isRotate;

    public VexEntityDrawShow(String id, VexEntityDraw entityDraw, int time, boolean isRotate) {
        this.id = id;
        this.entityDraw = entityDraw;
        this.time = time;
        this.isRotate = isRotate;
    }

    public VexEntityDrawShow(String id, VexEntityDraw entityDraw, int time, boolean isRotate, int z) {
        this.id = id;
        this.entityDraw = entityDraw;
        this.time = time;
        this.isRotate = isRotate;
        this.z = z;
    }


    public String getType() {
        return "\u000e\u001c;?\u0000\u0014\u0017\u0018\n\u0005";
    }

}
