package lk.vexview.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class KeyBoardHoldEvent extends Event {

    private Player player;

    private int key;

    private KeyBoardPressEvent.KeyPressType keyPressType;

    public KeyBoardHoldEvent(int kye, Player player, String typeString) {
        this.key = kye;
        this.player = player;
        this.keyPressType = KeyBoardPressEvent.KeyPressType.valueOf(typeString);
    }

    public KeyBoardPressEvent.KeyPressType getType() {
        return keyPressType;
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
