package me.piechuuu.core.listener;

import me.piechuuu.core.managers.CaseManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CaseKickQuitListener implements Listener {
    @EventHandler
    public void quit(PlayerQuitEvent e) {
        left(e.getPlayer());
    }

    @EventHandler
    public void kick(PlayerKickEvent e) {
        left(e.getPlayer());
    }

    private void left(final Player p) {
        if (CaseManager.isInCase(p)) {
            CaseManager.removeCase(p);
        }
    }
}
