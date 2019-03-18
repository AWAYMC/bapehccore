package net.arehard.core.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.gui.Admi;
import net.arehard.core.gui.Menu;

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
        
        if (is.getType() == Material.BOOK) {
            Admi.main(p);

        }
        
        if (is.getType() == Material.FEATHER) {
        	if (!p.hasPermission("arehard.core.fly.lobby")) {
                p.sendMessage(ChatUtil.fixColor("&4Blad: &cNa lobby moze latac tylko ranga: VIP, SPONSOR"));
                return;
            }
        	if (p.getAllowFlight()) {
                p.sendMessage(ChatUtil.fixColor("&8>> &7Fly zostal: &cWYLACZONY!"));
                p.setAllowFlight(false);
            }
            else {
                p.sendMessage(ChatUtil.fixColor("&8>> &7Fly zostal: &cWLACZONY!"));
                p.setAllowFlight(true);

            }
        }
    }
}