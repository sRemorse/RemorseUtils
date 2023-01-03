package com.remorse.remorseutils.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;

public class GodCommand implements CommandExecutor {

    public ArrayList<String> godPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player){
            if (player.hasPermission("remorseutils.god")){
                if (args.length == 0){
                    toggleGod(player);
                }
            }
        }
        return true;
    }

    private void toggleGod(Player player){
        String name = player.getName();
        if(!godPlayers.contains(name)){
            godPlayers.add(name);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6[RemorseUtils] &9Godmode enabled"));
        } else {
            godPlayers.remove(name);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[RemorseUtils] &9Godmode disabled"));
        }
    }




}
