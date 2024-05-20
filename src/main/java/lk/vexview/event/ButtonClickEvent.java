package lk.vexview.event;

import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.VexButton;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class ButtonClickEvent extends Event implements Cancellable {

    private Player player;

    private VexGui vexGui;

    private VexButton vexButton;

    public ButtonClickEvent(VexButton vexButton, VexGui vexGui, Player player) {
        this.vexButton = vexButton;
        this.vexGui = vexGui;
        this.player = player;
    }

    public VexButton getButton(){
        return vexButton;
    }

    public Object getButtonID() {
        return this.vexButton.getId();
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
