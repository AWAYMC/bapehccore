package net.arehard.core.listeners;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class FoodLevelChangeListener implements Listener
{
    @EventHandler
    public void onFoodChange(final FoodLevelChangeEvent e) {
        final Player p = (Player)e.getEntity();
        if (p.getWorld().getName().contains("world")) {
            e.setCancelled(true);
        }
    }
}