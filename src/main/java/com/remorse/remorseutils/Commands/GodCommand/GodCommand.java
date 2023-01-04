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
                    toggleGodTarget(sender,target);
                    return true;
                }
        return true;
    }

    private void toggleGod(Player player){
        String name = player.getName();
        if(!GodModeHandler.getGodPlayers().contains(name)){
            GodModeHandler.addPlayer(name);
            player.setHealth(20.0); // Heal player to max health when adding them to the GodPlayers list
            player.setFoodLevel(20);
            player.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &aGodmode enabled"));
        } else {
            GodModeHandler.removePlayer(name);
            player.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &cGodmode disabled"));
        }
    }

    private void toggleGodTarget(CommandSender sender, Player target){
        String targetPlayer = target.getName();
        if(!GodModeHandler.getGodPlayers().contains(targetPlayer)){
            GodModeHandler.addPlayer(targetPlayer);
            target.setHealth(20.0); // Heal target to max health when adding them to the GodPlayers list
            target.setFoodLevel(20);

            if(!sender.getName().equals(targetPlayer))
                sender.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &aGodmode enabled for %target%".replace("%target%", target.getName()) ));
            target.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &aGodmode has been enabled for you"));
        } else {
            GodModeHandler.removePlayer(targetPlayer);
            if(!sender.getName().equals(targetPlayer))
                sender.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &cGodmode disabled for %target%".replace("%target%", target.getName()) ));
            target.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &cGodmode has been disabled for you"));
        }
    }

}
