package lk.vexview.hud;

import lk.vexview.gui.components.VexButton;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VexButtonShow extends VexShow{

    VexButton vb;

    public VexButtonShow(String id, VexButton vb, int time) {
        this.id = id;
        this.vb = vb;
        this.time = time;
    }

    public VexButtonShow(String id, VexButton vb, int time, int z) {
        this.id = id;
        this.vb = vb;
        this.time = time;
        this.z = z;
    }

    public Object getButtonId(){
        return vb.getID();
    }

    public VexButton getButton(){
        return vb;
    }


    public String getType() {
        return "\u0016\u0018\u0007\u001e\u0004\u001c";
    }

}
