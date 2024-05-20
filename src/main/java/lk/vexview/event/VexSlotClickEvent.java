package lk.vexview.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
public class VexSlotClickEvent extends Event {

    private ClickType clickType;

    private Player player;

    private int id;

    public VexSlotClickEvent(ClickType clickType, Player player, int id) {
        this.clickType = clickType;
        this.player = player;
        this.id = id;
    }

    public ItemStack getItem(){
        return new ItemStack(Material.AIR);
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static enum ClickType {
        RIGHT_CLICK,
        LEFT_CLICK,
        MIDDLE_CLICK
    }

}
