package me.piechuuu.core.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

public class EnchantCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Ta komenda nie jest od poziomu konsoli");
            return false;
        }
        Player p = (Player) commandSender;
        if (!commandSender.hasPermission("bapehc.core.enchant")) {
            TitleAPI.sendTitle(p, 20, 50, 20, "§4Blad:", "§8» §cNie masz dostepu do tej komendy");
            return false;
        }
        if (strings.length < 1) {
            commandSender.sendMessage("§4Blad: §cPoprawne uzycie: §7/enchant <nazwa_enchantu> <level>");
            return false;
        } else if (strings.length == 2) {

            try {
                ItemStack item = p.getItemInHand();
                int enchant_level = Integer.parseInt(strings[1]);
                String enchant_name = strings[0];

                if (enchant_name.equalsIgnoreCase("sharpness")) {
                    item.addUnsafeEnchantments(Enchantment.DAMAGE_ALL, enchant_level);
                }

            }catch (NumberFormatException e){
                TitleAPI.sendTitle(p, 20, 50, 20, "§4Blad:", "§8» §cPoprawne uzycie: §7/enchant <nazwa> <level> ");
                return false;
            }
        }
    }
}
