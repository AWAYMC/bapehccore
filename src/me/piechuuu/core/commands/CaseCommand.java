package me.piechuuu.core.commands;

import me.piechuuu.core.CorePlugin;
import me.piechuuu.core.MagiCaseChatUtil.ChatUtil;
import me.piechuuu.core.MagiCaseChatUtil.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CaseCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.hasPermission(CorePlugin.getPlugin().getConfig().getString("casecmd.permission"))|| !commandSender.isOp()) {
            commandSender.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.permission-message")).replace("{PERM}", CorePlugin.getPlugin().getConfig().getString("casecmd.permission")));
            return true;
        }
        if (strings.length < 3){
            commandSender.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.usage")));
            return true;
        }
        if (!isInteger(strings[2])) {
            commandSender.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.notint")));
            return true;
        }
        final int size = Integer.parseInt(strings[2]);
        if (strings[0].equalsIgnoreCase("case")) {
            if (strings[1].equalsIgnoreCase("all")) {
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    giveCase(all, size);
                }
                Bukkit.broadcastMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.allcase").replace("{ILOSC}", strings[2])));
                return true;
            }
            final Player o = Bukkit.getPlayer(strings[1]);
            if (!o.isOnline()) {
                commandSender.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.offline")));
                return true;
            }
            giveCase(o, size);
            commandSender.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.dalescase")).replace("{NICK}", o.getName()).replace("{ILOSC}", String.valueOf(size)));
            return true;
        }
        if (strings[0].equalsIgnoreCase("key")) {
            if (strings[1].equalsIgnoreCase("all")) {
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    giveKey(all, size);
                }
                Bukkit.broadcastMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.allkey").replace("{ILOSC}", strings[2])));
                return true;
            }
            final Player o = Bukkit.getPlayer(strings[1]);
            if (!o.isOnline()) {
                commandSender.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.offline")));
                return true;
            }
            giveKey(o, size);
            commandSender.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.daleskey").replace("{NICK}", o.getName()).replace("{ILOSC}", String.valueOf(size))));
            return true;
        }
        else {
            commandSender.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.usage")));
            return true;
        }
    }

    private void giveCase(final Player p, final int size) {
        final ItemStack i = new ItemBuilder(Material.CHEST, size).setTitle(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("case.name"))).addLores(ChatUtil.fColor(CorePlugin.getPlugin().getConfig().getStringList("case.lore"))).addEnchantment(Enchantment.DURABILITY, 10).build();
        giveItems(p, i);
        p.updateInventory();
        p.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.dostalescase")).replace("{ILOSC}", String.valueOf(size)));
    }

    private void giveKey(final Player p, final int size) {
        final ItemStack i = new ItemBuilder(Material.NAME_TAG, size).setTitle(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("key.name"))).addLores(ChatUtil.fColor(CorePlugin.getPlugin().getConfig().getStringList("key.lore"))).addEnchantment(Enchantment.DURABILITY, 10).build();
        giveItems(p, i);
        p.updateInventory();
        p.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("casecmd.dostaleskey")).replace("{ILOSC}", String.valueOf(size)));
    }
    public static void giveItems(final Player p, final ItemStack... items) {
        final Inventory i = (Inventory) p.getInventory();
        final HashMap<Integer, ItemStack> notStored = (HashMap<Integer, ItemStack>) i.addItem(items);
        for (final Map.Entry<Integer, ItemStack> e : notStored.entrySet()) {
            p.getWorld().dropItemNaturally(p.getLocation(), (ItemStack) e.getValue());
        }
    }
    public static boolean isInteger(final String string) {
        return Pattern.matches("-?[0-9]+", string.subSequence(0, string.length()));
    }
}


