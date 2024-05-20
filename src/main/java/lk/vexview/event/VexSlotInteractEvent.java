package lk.vexview.event;


import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class VexSlotInteractEvent extends Event implements Cancellable {

    private Player player;

    private int id;

    public VexSlotInteractEvent(Player player, int id) {
        this.player = player;
        this.id = id;
    }

    public boolean isInventory() {
        return false;
    }

    public static class Post extends VexSlotInteractEvent {

        public Post(Player player, int id) {
            super(player, id);
        }
    }

    public static class Pre extends VexSlotInteractEvent {

        public Pre(Player player, int id) {
            super(player, id);
        }
    }


    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

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
