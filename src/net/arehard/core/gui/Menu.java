package net.arehard.core.gui;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.ChatUtil.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Menu {

    public static void main(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9, (ChatUtil.fixColor("&cWybierz tryb")));
        ItemBuilder menu = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&4&LKNOCKBACK")));
        inv.setItem(0, menu.build());
        p.openInventory(inv);
    }
}