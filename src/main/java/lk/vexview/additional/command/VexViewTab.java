package lk.vexview.additional.command;


import com.daxton.unrealcore.application.base.YmlFileUtil;
import lk.vexview.additional.controller.VexViewController;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VexViewTab implements TabCompleter {


    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String head, String[] args) {
        List<String> commandList = new ArrayList<>();

        if(head.equals("opengui")){
            if (args.length == 1){
                commandList = Bukkit.getOnlinePlayers().stream()
                        .map(org.bukkit.entity.Player::getName)
                        .collect(Collectors.toList());
            }
            if (args.length == 2){
                commandList = new ArrayList<>(VexViewController.unrealCoreGUIMap.keySet());
            }
        }


        return commandList;
    }
}
