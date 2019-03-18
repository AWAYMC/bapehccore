package net.arehard.core.listeners;

import org.bukkit.event.block.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.*;

import net.arehard.core.Main;

public class WaterPlaceListener implements Listener
{
    @EventHandler
    public void onWater(final BlockFromToEvent event) {
        if (event.getBlock().getTypeId() == 11 || event.getBlock().getTypeId() == 9) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onWaterEmpty(final PlayerBucketEmptyEvent event) {
        final Block block = event.getBlockClicked().getRelative(event.getBlockFace(), 1);
        if (event.getBucket().equals((Object)Material.WATER_BUCKET)) {
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    block.setType(Material.AIR);
                    Bukkit.getScheduler().runTaskLater((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (!event.getPlayer().getWorld().getName().contains("world")) {
                                event.getPlayer().getInventory().removeItem(new ItemStack[] { new ItemStack(Material.WATER_BUCKET, 16) });
                                event.getPlayer().getInventory().removeItem(new ItemStack[] { new ItemStack(Material.BUCKET, 16) });
                                event.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.WATER_BUCKET) });
                                event.getPlayer().updateInventory();
                                event.setCancelled(true);
                            }
                        }
                    }, 10L);
                }
            }, 80L);
        }
    }
}
