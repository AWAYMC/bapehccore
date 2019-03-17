package net.arehard.core.listeners;

import net.arehard.core.gui.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        Action a = e.getAction();
        ItemStack is = e.getItem();

        if (a == Action.PHYSICAL || is == null || is.getType()== Material.AIR)
            return;

        if (is.getType() == Material.COMPASS) {
            Menu.main(p);

        }
    }
}