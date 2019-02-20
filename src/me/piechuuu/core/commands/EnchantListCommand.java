package me.piechuuu.core.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnchantListCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        TitleAPI.sendTitle(p, 20, 50, 20, "§4§lINFO", "§8» §cCzytaj czat ");
        commandSender.sendMessage("§8§m-----§8( §cLISTA §8)§m-----");
        commandSender.sendMessage("§8» §c/enchant sharpness <level> §7enchantuje ostrosc");
        commandSender.sendMessage("§8» §c/enchant digspeed <leval> §7enchantuje szybkosc kopania");
        commandSender.sendMessage("§8» §c/enchant unbreaking <level> §7enchantuje wytrzymalos");
        commandSender.sendMessage("§8» §c/enchant fireaspect <level> §7enchantuje ogien");
        commandSender.sendMessage("§8» §c/enchant protection <level> §7enchantuje ochrone");
        commandSender.sendMessage("§8» §c/enchant fortune <level> §7enchantuje szczescie");
        commandSender.sendMessage("§8» §c/enchant infinity <level> §7enchantuje nieskonczonosc");
        commandSender.sendMessage("§8» §c/enchant punch <level> §7enchantuje odrzut");
        commandSender.sendMessage("§8» §c/enchant knockback <level> §7enchantuje odrzut");
        commandSender.sendMessage("§8» §c/enchant silktouch <level> §7enchantuje wypadnie itemow");
        commandSender.sendMessage("§8» §c/enchant power <level> §7enchantuje moc ");
        commandSender.sendMessage("§8» §c/enchant flame <levek> §7enchantuje ogien ");
        commandSender.sendMessage("§8§m-----§8( §cLISTA §8)§m-----");
        return false;
    }
}
