package com.remorse.remorseutils.Commands.God;

import com.remorse.remorseutils.RemorseUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GodListCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {
            if (!player.hasPermission("remorseutils.god.list")) {
                sender.sendMessage(RemorseUtils.translate("&c[RemorseUtils] You don't have permission to do this!"));
                return true;
            }

            if (args.length == 0) {
                ArrayList<String> names = GodModeHandler.getGodPlayers();

                if (names.isEmpty()){
                    sender.sendMessage(RemorseUtils.translate("&7[RemorseUtils] No players with godmode"));
                    return true;
                }

                sender.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &fThese players have godmode:"));
                for (String name : names) {
                    sender.sendMessage(RemorseUtils.translate("&a[-] &7" + name));
                    return true;
                }
            }


        }
    return true;
    }
}
