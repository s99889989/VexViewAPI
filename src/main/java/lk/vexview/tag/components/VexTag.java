package lk.vexview.tag.components;

import lk.vexview.tag.TagDirection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class VexTag {

    private double x;

    private double y;

    private double z;

    private TagDirection tagDirection;

    private String id;

    private String type;

    public VexTag(double x, double y, double z, TagDirection tagDirection, String id, String type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.tagDirection = tagDirection;
        this.id = id;
        this.type = type;
    }

    public float getRotX(){
        return tagDirection.getAngle_x();
    }

    public float getRotY(){
        return tagDirection.getAngle_y();
    }

    public float getRotZ(){
        return tagDirection.getAngle_z();
    }

    public int getRealId() {
        return 0;
    }


}
