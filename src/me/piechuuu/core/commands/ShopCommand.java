package me.piechuuu.core.commands;

import me.piechuuu.core.CorePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ShopCommand implements CommandExecutor {

    CorePlugin plugin = CorePlugin.hook();

    Inventory inv;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Ta komenda nie jest od poziomu konsoli");
            return false;
        }
        Player p = (Player) commandSender;

        ItemStack testItem = new ItemStack(Material.DIAMOND);
        ItemMeta tiMeta = testItem.getItemMeta();
        tiMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bDiament &8| &7kliknij aby zakupic"));
        tiMeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&cKoszt &8| &7(Coins)"), "300"));
        testItem.setItemMeta(tiMeta);
        inv = Bukkit.createInventory(null, 9, "§7MENU §8| §cSKLEP");
        inv.setItem(4, testItem);
        p.openInventory(inv);
        return true;
    }
}

