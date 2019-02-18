package me.piechuuu.core.listener;

import me.piechuuu.core.CorePlugin;
import me.piechuuu.core.MagiCaseChatUtil.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener
{
    @EventHandler
    public void c(final InventoryClickEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("gui.name")))) {
            e.setCancelled(true);
        }
    }
}
