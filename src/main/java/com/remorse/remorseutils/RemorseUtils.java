package com.remorse.remorseutils;

import com.remorse.remorseutils.Commands.GodCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class RemorseUtils extends JavaPlugin {

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

    public void registerEvents(){

    }

    private void registerCommands(){
        getCommand("god").setExecutor(new GodCommand(this));
    }


}
