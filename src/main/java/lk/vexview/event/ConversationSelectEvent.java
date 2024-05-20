package lk.vexview.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class ConversationSelectEvent extends Event {

    private Player player;

    private int option;

    public ConversationSelectEvent(int option, Player player) {
        this.player = player;
        this.option = option;
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