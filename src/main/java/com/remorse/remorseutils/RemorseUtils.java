package com.remorse.remorseutils;

import com.remorse.remorseutils.Commands.GodCommand;
import com.remorse.remorseutils.Listeners.GodModeHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class RemorseUtils extends JavaPlugin implements Listener {

    public Logger log = getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic

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
        getServer().getPluginManager().registerEvents(new GodModeHandler(), this);
    }

    private void registerCommands(){
        getCommand("god").setExecutor(new GodCommand());
    }


}
