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
        e.setJoinMessage(ChatUtil.fixColor("&8>> &7Gracz &c" + e.getPlayer().getName() + " &7dolaczyl na serwer!"));
        p.teleport(Bukkit.getWorld("world").getSpawnLocation());
        p.getInventory().clear();
        p.getInventory().setArmorContents((ItemStack[])null);
        p.setFoodLevel(20);
        p.setFoodLevel(20);
        p.setHealth(20);
        p.getInventory().clear();
        final ItemStack sword = new ItemStack(Material.COMPASS);
        final ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatUtil.fixColor("&cTRYBY"));
        sword.setItemMeta(swordMeta);
        p.getInventory().setItem(4, sword);
    }
}
