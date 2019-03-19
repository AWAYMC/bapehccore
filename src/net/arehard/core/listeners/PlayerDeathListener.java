package net.arehard.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.ChatUtil.ItemBuilder1;
import net.arehard.core.managers.CoinsManager;

public class PlayerDeathListener implements Listener
{
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onDeathes(final PlayerDeathEvent e) {
        final Player killer = e.getEntity().getKiller();
        final Player p = ((OfflinePlayer) e).getPlayer();
        if (killer instanceof Player) {
            killer.sendTitle(ChatUtil.fixColor("&2ZABOJSTWO!"), ChatUtil.fixColor("&a+50 coins!"));
            CoinsManager.setCoins(killer.getName(), CoinsManager.getCoins(killer.getName()) + 50);

        }
    }
}