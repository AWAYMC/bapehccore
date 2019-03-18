package net.arehard.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.managers.CoinsManager;

public class PlayerDeathListener implements Listener
{
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onDeathes(final PlayerDeathEvent e) {
        final Player killer = e.getEntity().getKiller();
        if (killer instanceof Player) {
            killer.sendTitle(ChatUtil.fixColor("&2ZABOJSTWO!"), ChatUtil.fixColor("&a+50 coins!"));
            CoinsManager.setCoins(killer.getName(), CoinsManager.getCoins(killer.getName()) + 50);
        }
    }
}