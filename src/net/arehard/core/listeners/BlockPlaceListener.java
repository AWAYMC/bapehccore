package net.arehard.core.listeners;


import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

import net.arehard.core.Main;
import net.arehard.core.ChatUtil.ChatUtil;

public class BlockPlaceListener implements Listener
{
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(final BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.COBBLESTONE) {
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    event.getBlock().setType(Material.AIR);
                    if (!event.getPlayer().getWorld().getName().contains("world")) {
                        ChatUtil.giveItems(event.getPlayer(), new ItemStack(Material.COBBLESTONE));
                    }
                }
            }, 110L);
        }
    }
    
    @EventHandler
    public void onRegion(final BlockPlaceEvent event) {
        if (event.getPlayer().getWorld().getName().contains("world") && event.getBlock().getType() != Material.COBBLESTONE && event.getBlock().getType() != Material.SLIME_BLOCK && event.getBlock().getType() == Material.WATER_BUCKET && !event.getPlayer().hasPermission("core.cmd.mod")) {
            event.getPlayer().sendMessage(ChatUtil.fixColor("&4Blad: &cNie mozesz budowac na tym trybie!"));
            event.setCancelled(true);
        }
    }
}