package lk.vexview.gui.components;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface ButtonFunction {
    void run(Player player);
}
