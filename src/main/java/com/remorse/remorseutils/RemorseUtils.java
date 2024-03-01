package com.remorse.remorseutils;

import com.remorse.remorseutils.Commands.God.GodCommand;
import com.remorse.remorseutils.Commands.God.GodListCommand;
import com.remorse.remorseutils.Commands.God.GodModeHandler;
import com.remorse.remorseutils.Commands.Kick.KickCommand;
import com.remorse.remorseutils.Commands.Rain.RainCommand;
import com.remorse.remorseutils.Listeners.GodModeListener;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class RemorseUtils extends JavaPlugin implements Listener {

    public Logger log = getLogger();

    // Color message utility
    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&',message);
    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        new GodModeHandler();

        registerCommands();
        registerEvents();
        log.info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("Plugin disabled!");
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new GodModeListener(), this);
    }

    private void registerCommands(){
        getCommand("god").setExecutor(new GodCommand());
        getCommand("gods").setExecutor(new GodListCommand());
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("rain").setExecutor(new RainCommand());
    }


}
