package me.piechuuu.core.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import me.piechuuu.core.CorePlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
                // enchantuje dany przedmiot
                if (enchant_name.equalsIgnoreCase("sharpness")) {
                    item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("knockback")) {
                    item.addUnsafeEnchantment(Enchantment.KNOCKBACK, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("fortune")) {
                    item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("digspeed")) {
                    item.addUnsafeEnchantment(Enchantment.DIG_SPEED, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("fortune")) {
                    item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("silktouch")) {
                    item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("protection")) {
                    item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("unbreaking")) {
                    item.addUnsafeEnchantment(Enchantment.DURABILITY, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("fireaspect")) {
                    item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("punch")) {
                    item.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("infinity")) {
                    item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("power")) {
                    item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, enchant_level);
                }else if(enchant_name.equalsIgnoreCase("flame")){
                    item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, enchant_level);
                }else{
                    TitleAPI.sendTitle(p, 20, 50, 20, "§4§lBlad", "§8» §cNie znaleziono przedmiotu §7/enchantlist");
                    return true;
                }
                p.sendMessage("§cPomyslnie enchantowano przedmiot §7" + enchant_name + "na level" + enchant_level + "§7:)");
            }catch (NumberFormatException e){
                TitleAPI.sendTitle(p, 20, 50, 20, "§4§lBlad", "§8» §cPoprawne uzycie: §7/enchant <nazwa> <level> ");
            }
        }else{
            TitleAPI.sendTitle(p, 20, 50, 20, "§4§lBlad", "§8» §cPoprawne uzycie: §7/enchant <nazwa> <level> ");
        }
        return false;
    }
}
