package me.piechuuu.core.listener;

import me.piechuuu.core.managers.CaseManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class CaseDropListener implements Listener
{
    @EventHandler(priority = EventPriority.MONITOR)
    public void drop(final PlayerDropItemEvent e) {
        if (CaseManager.isInCase(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
