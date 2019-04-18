package net.arehard.core.gui;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.ChatUtil.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Drop {

    public static void main(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9, (ChatUtil.fixColor("&7MENU &8| &7DROPU")));
        ItemBuilder Drop1 = new ItemBuilder(Material.STAINED_GLASS_PANE).getTitle((ChatUtil.fixColor("&4&LWLASCICIEL"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor(""));
        ItemBuilder Drop2 = new ItemBuilder(Material.STONE).getTitle((ChatUtil.fixColor("&cDrop ze &7stone"))).getLore(ChatUtil.fixColor("&7Aby zobaczyc drop")).getLore(ChatUtil.fixColor("&7kliknij aby przejsc &cPPM")).getLore(ChatUtil.fixColor(""));
        ItemBuilder Drop3 = new ItemBuilder(Material.STAINED_GLASS_PANE).getTitle((ChatUtil.fixColor(""))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor(""));
        ItemBuilder Drop4 = new ItemBuilder(Material.STAINED_GLASS_PANE).getTitle((ChatUtil.fixColor(""))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor(""));
        ItemBuilder Drop5 = new ItemBuilder(Material.CHEST).getTitle((ChatUtil.fixColor("&cDrop z &7magicznej skrzyni"))).getLore(ChatUtil.fixColor("&7Aby zobaczyc drop")).getLore(ChatUtil.fixColor("&7kilknij aby przejsc &cPPM")).getLore(ChatUtil.fixColor(""));
        ItemBuilder Drop6 = new ItemBuilder(Material.STAINED_GLASS_PANE).getTitle((ChatUtil.fixColor(""))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor(""));
        ItemBuilder Drop7 = new ItemBuilder(Material.STAINED_GLASS_PANE).getTitle((ChatUtil.fixColor(""))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor(""));
        ItemBuilder Drop8 = new ItemBuilder(Material.MOSSY_COBBLESTONE).getTitle((ChatUtil.fixColor("&cDrop z &7cobblex"))).getLore(ChatUtil.fixColor("&7Aby zobaczyc drop")).getLore(ChatUtil.fixColor("&7kliknij aby przejsc &cPPM")).getLore(ChatUtil.fixColor(""));
        ItemBuilder Drop9 = new ItemBuilder(Material.STAINED_GLASS_PANE).getTitle((ChatUtil.fixColor(""))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor(""));
        inv.setItem(0, Drop1.build());
        inv.setItem(1, Drop2.build());
        inv.setItem(2, Drop3.build());
        inv.setItem(3, Drop4.build());
        inv.setItem(4, Drop5.build());
        inv.setItem(5, Drop6.build());
        inv.setItem(6, Drop7.build());
        inv.setItem(7, Drop8.build());
        inv.setItem(8, Drop9.build());
        p.openInventory(inv);
    }
}
