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
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na sharpness");
                }else if(enchant_name.equalsIgnoreCase("knockback")) {
                    item.addUnsafeEnchantment(Enchantment.KNOCKBACK, enchant_level);
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na knockback");
                }else if(enchant_name.equalsIgnoreCase("fortune")) {
                    item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, enchant_level);
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na fortune");
                }else if(enchant_name.equalsIgnoreCase("digspeed")) {
                    item.addUnsafeEnchantment(Enchantment.DIG_SPEED, enchant_level);
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na digspeed");
                }else if(enchant_name.equalsIgnoreCase("fortune")) {
                    item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, enchant_level);
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na fortune");
                }else if(enchant_name.equalsIgnoreCase("silktouch")) {
                    item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, enchant_level);
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na silktouch");
                }else if(enchant_name.equalsIgnoreCase("protection")) {
                    item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, enchant_level);
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na protection");
                }else if(enchant_name.equalsIgnoreCase("unbreaking")) {
                    item.addUnsafeEnchantment(Enchantment.DURABILITY, enchant_level);
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na unbreaking");
                }else if(enchant_name.equalsIgnoreCase("fireaspect")){
                    item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, enchant_level);
                    p.sendMessage(CorePlugin.prefix + " §cPomyslnie enchantowano na fireaspect");
                }else{
                    p.sendMessage("§4Blad: §cLista enchantow: §7sharpness,knockback,infinity,fortune,silktouch,digspeed,fireaspect,punch,protection,unbreaking");
                    return true;
                }
                p.sendMessage("§4Blad: §cPosiadasz ze soba juz przedmiot o tym enchancie");
            }catch (NumberFormatException e){
                TitleAPI.sendTitle(p, 20, 50, 20, "§4§lBlad", "§8» §cPoprawne uzycie: §7/enchant <nazwa> <level> ");
            }
        }else{
            TitleAPI.sendTitle(p, 20, 50, 20, "§4§lBlad", "§8» §cPoprawne uzycie: §7/enchant <nazwa> <level> ");
        }
        return false;
    }
}
