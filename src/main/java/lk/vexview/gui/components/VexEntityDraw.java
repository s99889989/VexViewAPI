package lk.vexview.gui.components;

import com.daxton.unrealcore.nms.NMSEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

@Getter
@Setter
@ToString
public class VexEntityDraw extends VexComponents {

    private int x;

    private int y;

    private int scale;

    private Entity entity;

    private boolean isSee;

    public VexEntityDraw(int x, int y, int scale, Entity entity) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.entity = entity;
    }

    public VexEntityDraw(int x, int y, int scale, EntityType type) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public boolean isSeeMouse()  {
        return isSee;
    }

    public void setSee(boolean isSee) {
        this.isSee = isSee;
    }

    public EntityType getEntityType(){
        return entity.getType();
    }

    public byte[] getNbtArray(){
        String s = NMSEntity.entityNBTtoString(entity);
        return s.getBytes();
    }

    public String getType(){
        return super.getType();
    }

}
