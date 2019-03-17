package net.arehard.core.listeners;

import net.arehard.core.ChatUtil.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if ((ChatUtil.fixColor("&cWybierz tryb")).equalsIgnoreCase(e.getClickedInventory().getName())) {
            e.setCancelled(true);
            if (e.getSlot() == 0) {
                p.closeInventory();
            }
        }
    }
}
