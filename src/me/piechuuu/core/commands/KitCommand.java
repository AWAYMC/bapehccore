package me.piechuuu.core.commands;

import me.piechuuu.core.MagiCaseChatUtil.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class KitCommand implements CommandExecutor, Listener {

    private Inventory kity = Bukkit.createInventory(null, 9, "§aZestawy");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(cmd.getName().equalsIgnoreCase("kit")) {
            if(!(sender instanceof Player)) {

            }
            else {
                Player p = (Player)sender;
                createKitInv();
                p.openInventory(kity);
            }
        }
        return false;
    }
    private void createKitInv() {
        for(int i = 0; i < 9; i++) {
            final ItemStack pane = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)13).setTitle(" ").build();
            kity.setItem(i, pane);
        }

        List<String> lore = new ArrayList<>();
        lore.add("§bLPM aby wziac zestaw");
        lore.add("§bPPM aby zobaczyc zawartosc zestawu");

        final ItemStack kitGracz = new ItemBuilder(Material.WOOD_SWORD, 1).setTitle("§aZestaw GRACZA").addLores(lore).build();
        final ItemStack kitVip = new ItemBuilder(Material.IRON_SWORD, 1).setTitle("§aZestaw VIPA").addLores(lore).build();
        final ItemStack kitSVip = new ItemBuilder(Material.DIAMOND_SWORD, 1).setTitle("§aZestaw SVIPA").addLores(lore).build();
        final ItemStack kitJedzenie = new ItemBuilder(Material.COOKED_BEEF, 1).setTitle("§aZestaw MIESKO").addLores(lore).build();
        final ItemStack kitAdmin = new ItemBuilder(Material.STICK, 1).setTitle("§aZestaw ADMINA").addLores(lore).build();

        kity.setItem(2, kitGracz);
        kity.setItem(3, kitVip);
        kity.setItem(4, kitSVip);
        kity.setItem(5, kitJedzenie);
        kity.setItem(6, kitAdmin);
    }

}
