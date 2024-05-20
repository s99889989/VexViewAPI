package lk.vexview.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class DownloadFailedEvent extends Event {

    private Player player;

    private Type type;

    public DownloadFailedEvent(Player player, Type type) {
        this.player = player;
        this.type = type;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static enum Type {
        BQ_NPC_IMAGE ,
        BUTTON ,
        CHECKBOX,
        GIFIMAGE,
        GUI,
        HUD,
        IMAGE,
        LOGIN_IMAGE,
        SCOREBOARD_IMAGE,

    }

}
