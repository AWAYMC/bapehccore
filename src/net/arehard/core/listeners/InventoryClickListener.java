package net.arehard.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import net.arehard.core.ChatUtil.ChatUtil;


public class InventoryClickListener implements Listener{

	@EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        if ((ChatUtil.fixColor("&cWybierz tryb")).equalsIgnoreCase(event.getInventory().getName())) {
            event.setCancelled(true);
            if (event.getSlot() == 0) {
            	p.closeInventory();
            	p.sendMessage(ChatUtil.fixColor("&4&lPRACE NAD ARENA NADAL TRWAJA!"));
            	return;
            } 
        }
        if(event.getInventory().getType() == InventoryType.PLAYER)
        {
            event.setCancelled(true);
        }
        if ((ChatUtil.fixColor("&cAdministracja")).equalsIgnoreCase(event.getInventory().getName())) {
            event.setCancelled(true);
            if (event.getSlot() == 0) {
            	event.setCancelled(true);
            }
            if (event.getSlot() == 1) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 2) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 3) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 4) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 5) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 6) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 7) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 8) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 9) {
            	event.setCancelled(true);
            } 
        }
    }
}