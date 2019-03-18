package net.arehard.core.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.ChatUtil.ItemBuilder;


public class Admi {

	public static void main(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9, (ChatUtil.fixColor("&cAdministracja")));
        ItemBuilder admin1 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&4&LWLASCICIEL"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cadrianekk")).getLore(ChatUtil.fixColor(""));
        ItemBuilder admin2 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&4&LWLASCICIEL"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cPiechuuu")).getLore(ChatUtil.fixColor(""));
        ItemBuilder admin3 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&4&LADMIN"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cBRAK")).getLore(ChatUtil.fixColor(""));
        ItemBuilder admin4 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&2&lMODERATOR"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cBRAK")).getLore(ChatUtil.fixColor(""));
        ItemBuilder admin5 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&2&LMODERATOR"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cBRAK")).getLore(ChatUtil.fixColor(""));
        ItemBuilder admin6 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&3&lHELPER"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cBRAK")).getLore(ChatUtil.fixColor(""));
        ItemBuilder admin7 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&3&LHELPER"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cBRAK")).getLore(ChatUtil.fixColor(""));
        ItemBuilder admin8 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&3&LHELPER"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cBRAK")).getLore(ChatUtil.fixColor(""));
        ItemBuilder admin9 = new ItemBuilder(Material.PAPER).getTitle((ChatUtil.fixColor("&3&LHELPER"))).getLore(ChatUtil.fixColor("")).getLore(ChatUtil.fixColor("&7NICK&8: &cBRAK")).getLore(ChatUtil.fixColor(""));
        inv.setItem(0, admin1.build());
        inv.setItem(1, admin2.build());
        inv.setItem(2, admin3.build());
        inv.setItem(3, admin4.build());
        inv.setItem(4, admin5.build());
        inv.setItem(5, admin6.build());
        inv.setItem(6, admin7.build());
        inv.setItem(7, admin8.build());
        inv.setItem(8, admin9.build());
        p.openInventory(inv);
    }
}