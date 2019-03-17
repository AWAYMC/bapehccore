package net.arehard.core.listeners;

import net.arehard.core.ChatUtil.ChatUtil;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class PlayerJoinListener implements Listener{
	

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        e.setJoinMessage(ChatUtil.fixColor("&8>> &7Uzytkownik &c" + e.getPlayer().getName() + " &7dolaczyl na serwer!"));
        p.teleport(Bukkit.getWorld("world").getSpawnLocation());
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.setFoodLevel(20);
        p.setFoodLevel(20);
        p.setHealth(20);
        p.getInventory().clear();
        
        final ItemStack sword = new ItemStack(Material.COMPASS);
        final ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatUtil.fixColor("&cTRYBY"));
        sword.setItemMeta(swordMeta);
        
        final ItemStack sword1 = new ItemStack(Material.BOOK);
        final ItemMeta sword1Meta = sword1.getItemMeta();
        sword1Meta.setDisplayName(ChatUtil.fixColor("&cADMINISTRACJA"));
        sword1.setItemMeta(sword1Meta);
        
        final ItemStack sword2 = new ItemStack(Material.FEATHER);
        final ItemMeta sword2Meta = sword2.getItemMeta();
        sword2Meta.setDisplayName(ChatUtil.fixColor("&cFLY NA LOBBY"));
        sword2.setItemMeta(sword2Meta);
        
        final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        final ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(ChatUtil.fixColor(""));
        glass.setItemMeta(glassMeta);
        
        p.getInventory().setItem(0, sword1);
        p.getInventory().setItem(4, sword);
        p.getInventory().setItem(8, sword1);
        p.getInventory().setItem(2, sword2);
        p.getInventory().setItem(6, sword2);
        p.getInventory().setItem(1, glass);
        p.getInventory().setItem(5, glass);
        p.getInventory().setItem(3, glass);
        p.getInventory().setItem(7, glass);

    }
    
 
}

