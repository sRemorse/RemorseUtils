package com.remorse.remorseutils.Commands.Kick;

import com.remorse.remorseutils.RemorseUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        final StringBuilder reason = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            reason.append(args[i]).append(" ");
        }

        if (!sender.hasPermission("remorseutils.kick")){
            sender.sendMessage(RemorseUtils.translate("&c[RemorseUtils] You don't have permission to do this!"));
        return true;
    }

        if (!(args.length > 0)){
            sender.sendMessage(RemorseUtils.translate("&c[RemorseUtils] Usage: /kick [player] [reason]"));
        } else {
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null){
                sender.sendMessage(RemorseUtils.translate("&c[RemorseUtils] User is not online"));
                return true;
            }
            if (args.length == 1) {
                target.kickPlayer(RemorseUtils.translate("&cYou have been kicked!"));
                sender.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &aYou have kicked " + target.getName()));
            }else {
                target.kickPlayer(RemorseUtils.translate("&cYou have been kicked by " + sender.getName() + "\n Reason: &f" + reason.substring(0, reason.length() - 1)));
                sender.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &aYou have kicked " + target.getName()));
            }

        }

    return true;
    }


}
