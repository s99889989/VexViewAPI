package lk.vexview.gui.components;

import com.daxton.unrealcore.application.base.StringUtil;
import lk.vexview.tag.TagDirection;
import lk.vexview.tag.components.VexTag;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.UUID;

public class VexPlayerDraw extends VexEntityDraw {

    private String data;

    private int scale;

    VexEntityDraw vexEntityDraw;

    public VexPlayerDraw(int x, int y, int scale, UUID uuid, String name) {
        super(x, y, scale, EntityType.PLAYER);
        this.data = name;
    }

    public VexPlayerDraw(int x, int y, int scale, Object profile) {
        super(x, y, scale, EntityType.PLAYER);
    }


    public VexPlayerDraw(int x, int y, int scale, Player p) {
        super(x, y, scale, p);
    }


}
