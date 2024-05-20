package lk.vexview.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class KeyBoardPressEvent extends Event {

    private int key;

    private Player player;

    private boolean state;

    private KeyPressType keyPressType;

    public KeyBoardPressEvent(int key, Player player, boolean state, String typeString) {
        this.key = key;
        this.player = player;
        this.state = state;
        this.keyPressType = KeyPressType.valueOf(typeString);
    }

    public boolean getEventKeyState(){
        return this.state;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static enum KeyPressType {
        GUI,
        NOGUI
    }


}
