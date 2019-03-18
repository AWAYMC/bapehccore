package net.arehard.core.listeners;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.help.*;
import org.bukkit.event.*;
import net.arehard.core.ChatUtil.*;

public class PlayerCommandListener implements Listener
{
    @EventHandler
    public void onCommand(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        final String m = e.getMessage().split(" ")[0];
        final HelpTopic cmd = Bukkit.getServer().getHelpMap().getHelpTopic(m);
        if (cmd == null) {
            p.sendMessage(ChatUtil.fixColor("&4Blad: &cKomenda " + e.getMessage() + " nie istnieje!"));
            e.setCancelled(true);
        }
    }
}