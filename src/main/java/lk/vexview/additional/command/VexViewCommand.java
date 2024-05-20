package lk.vexview.additional.command;

import lk.vexview.additional.controller.VexViewController;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VexViewCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String head, String[] args) {
        if(head.equals("opengui")){
            if (args.length == 2){
                Player player = Bukkit.getPlayer(args[0]);
                String guiName = args[1];
                if(player != null){
                    VexViewController.open(player, guiName);
                }

            }
        }

        if(head.equals("vexreload")){
            VexViewController.reload();
        }

        return false;
    }
}
