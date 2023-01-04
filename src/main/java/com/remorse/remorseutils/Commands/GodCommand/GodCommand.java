package com.remorse.remorseutils.Commands.GodCommand;

import com.remorse.remorseutils.RemorseUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // God on yourself
        if(sender instanceof Player player) {
            if (!player.hasPermission("remorseutils.god")){
                sender.sendMessage(RemorseUtils.translate("&c[RemorseUtils] You don't have permission to do this!"));
                return true;
            }
            if (args.length == 0) {
                toggleGod(player);
                return true;
            }
        }

            // God on target
            if (!sender.hasPermission("remorseutils.god.others")) {
                sender.sendMessage(RemorseUtils.translate("&c[RemorseUtils] You don't have permission to do this to that player!"));
                return true;
            }
                if (args.length > 0) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null){
                        sender.sendMessage(RemorseUtils.translate("&c[RemorseUtils] User is not online"));
                        return true;
                    }
                    toggleGod(target);
                    return true;
                }
        return true;
    }

    private void toggleGod(Player player){
        String name = player.getName();
        if(!GodModeHandler.getGodPlayers().contains(name)){
            GodModeHandler.addPlayer(name);
            player.setHealth(20.0); // Heal player to max health when adding them to the GodPlayers list
            player.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &aGodmode enabled"));
        } else {
            GodModeHandler.removePlayer(name);
            player.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &cGodmode disabled"));
        }
    }

}
