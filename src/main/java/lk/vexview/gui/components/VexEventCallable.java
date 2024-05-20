package lk.vexview.gui.components;

import lk.vexview.event.VexSlotClickEvent;
import org.bukkit.entity.Player;

public interface VexEventCallable {

    void onKeyPressed(Player player, int var2, boolean var3);

    void onSlotClick(Player player, VexSlot vexSlot, VexSlotClickEvent.ClickType clickType);

    void onSlotInteractPre(Player player, int var2, boolean var3);

    void onSlotInteractPost(Player player, int var2, boolean var3);

    void onButtonClick(Player player, VexButton vexButton);

    void onGuiOpened(Player player);

    void onGuiClosed(Player player);

}
