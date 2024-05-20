package lk.vexview.hud;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class VexShow {

    protected String id;

    protected int time;

    protected String type;

    protected int x;

    protected int y;

    protected int z;

}
