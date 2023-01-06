package com.remorse.remorseutils.Listeners;

import com.remorse.remorseutils.Commands.God.GodModeHandler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class GodModeListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        Entity entity = event.getEntity();

        if(entity instanceof Player player){
            String name = player.getName();
            if(GodModeHandler.getGodPlayers().contains(name))
                event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Player player) {
            String name = player.getName();
            if (GodModeHandler.getGodPlayers().contains(name))
                event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTargeted(EntityTargetLivingEntityEvent event){
        Entity target = event.getTarget();

        if(target instanceof Player player){
            String name = player.getName();
            if (GodModeHandler.getGodPlayers().contains(name)){
                event.setCancelled(true);
            }
        }
    }

}
