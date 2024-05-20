package lk.vexview.event;

import lk.vexview.chat.VexChatChannel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class VexChannelChatEvent extends Event implements Cancellable {

    private VexChatChannel vexChatChannel;

    private Player player;

    private String message;

    public VexChannelChatEvent(VexChatChannel vexChatChannel, Player player, String message) {
        this.vexChatChannel = vexChatChannel;
        this.player = player;
        this.message = message;
    }

    public void setChatMessage(String message) {
        this.message = message;
    }

    public String getChatMessage() {
        return message;
    }

    public VexChatChannel getChannel(){
        return vexChatChannel;
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
