package lk.vexview.hud;

import lk.vexview.gui.components.VexComponents;
import lk.vexview.gui.components.expand.VexBase64Image;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexBase64ImageShow extends VexShow{

    private VexBase64Image vb;

    public VexBase64ImageShow(int z, VexBase64Image vb) {
        this.z = z;
        this.vb = vb;
    }

    public VexBase64ImageShow(VexBase64Image vb) {
        this.vb = vb;
    }

    public int getWidth(){
        return vb.getW();
    }

    public int getHeight(){
        return vb.getH();
    }

    public String getType() {
        return "v\u001fv;\u0013Ga\u0017`\bq";
    }

}
