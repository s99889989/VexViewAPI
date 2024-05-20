package lk.vexview.hud;

import lk.vexview.gui.OpenedVexGui;
import lk.vexview.gui.components.VexPlayerDraw;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexPlayerDrawShow extends VexShow{

    private VexPlayerDraw playerDraw;

    private boolean isRotate;

    public VexPlayerDrawShow(String id, VexPlayerDraw playerDraw, int time, boolean isRotate) {
        this.id = id;
        this.playerDraw = playerDraw;
        this.time = time;
        this.isRotate = isRotate;
    }

    public VexPlayerDrawShow(String id, VexPlayerDraw playerDraw, int time, boolean isRotate, int z) {
        this.id = id;
        this.playerDraw = playerDraw;
        this.time = time;
        this.isRotate = isRotate;
        this.z = z;
    }

    public String getType() {
        return "\u0018O-~\u0012N\u0014I\tT";
    }

}
