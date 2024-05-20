package lk.vexview.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class PlayerClientWindowSizeEvent extends Event {

    private Player player;

    private int width;

    private int height;

    public PlayerClientWindowSizeEvent(Player player, int width, int height) {
        this.player = player;
        this.width = width;
        this.height = height;
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
