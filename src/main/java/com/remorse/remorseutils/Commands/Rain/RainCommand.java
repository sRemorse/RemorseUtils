package com.remorse.remorseutils.Commands.Rain;

import com.remorse.remorseutils.RemorseUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player player)){
            sender.sendMessage(RemorseUtils.translate("&c[RemorseUtils] Console cannot do this"));
            return true;
        }

        if (player.hasPermission("remorseutils.rain")) {
            if (args.length == 0) {
                if (player.getWorld().isClearWeather()) {
                    player.getWorld().setStorm(true);
                    player.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &bRain enabled"));
                } else {
                    player.getWorld().setStorm(false);
                    player.getWorld().setThundering(false);
                    player.getWorld().setClearWeatherDuration(0);
                    player.sendMessage(RemorseUtils.translate("&6[RemorseUtils] &7Rain disabled"));
                }
            }
            return true;
        }
        player.sendMessage(RemorseUtils.translate("&c[RemorseUtils] You don't have permission to do this!"));
        return true;

    }
}


