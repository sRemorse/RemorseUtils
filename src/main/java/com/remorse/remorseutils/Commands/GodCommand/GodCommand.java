package com.remorse.remorseutils.Commands.GodCommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player player) {
            if (!player.hasPermission("remorseutils.god")) return false;
            if (args.length != 0) return false;
            toggleGod(player);
        }
        return true;
    }

    private void toggleGod(Player player){
        String name = player.getName();
        if(!GodModeHandler.getGodPlayers().contains(name)){
            GodModeHandler.addPlayer(name);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6[RemorseUtils] &9Godmode enabled"));
        } else {
            GodModeHandler.removePlayer(name);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[RemorseUtils] &9Godmode disabled"));
        }
    }

}
