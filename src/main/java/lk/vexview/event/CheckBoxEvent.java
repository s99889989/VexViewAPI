package lk.vexview.event;

import lk.vexview.gui.components.VexCheckBox;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class CheckBoxEvent extends Event {

    private Player player;

    private VexCheckBox checkBox;

    public CheckBoxEvent(Player player, VexCheckBox checkBox) {
        this.player = player;
        this.checkBox = checkBox;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
