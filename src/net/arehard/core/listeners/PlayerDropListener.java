package net.arehard.core.listeners;

import org.bukkit.event.player.*;

import net.arehard.core.ChatUtil.ChatUtil;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PlayerDropListener implements Listener
{
    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("core.cmd.mod")) {
            e.setCancelled(true);
            p.sendMessage(ChatUtil.fixColor("&4Blad: &cNie mozesz wyrzucac itemow na lobby!"));
        }
    }
}
