package me.piechuuu.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpWithCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        p.sendMessage("§8» §c/sklep §7Zakup itemow serwerowych");
        p.sendMessage("§8» §c/drop §7Zobacz drop serwerowy");
        p.sendMessage("§8» §c/craftingi §7Zobacz craftingi serwerowe");
        p.sendMessage("§8» §c/statystki §7Zobacz swoje statystki");
        p.sendMessage("§8» §c/tpa <nick> §7Teleportacja do danego gracza");
        p.sendMessage("§8» §c/kit §7Zobacz lub odbierz zestaw");
        p.sendMessage("§8» §c/g §7Informacje na temat gildii");
        p.sendMessage("§8» §c/vip §7Informacje na temat rangi §6vip");
        p.sendMessage("§8» §c/svip §7Informacje na tmemat rangi §5svip");
        p.sendMessage("");
        p.sendMessage("§8» §cFANPAGE: §7www.fb.com/bapehcpl");
        p.sendMessage("§8» §cWEBSITE: §7www.bapehc.pl/news");
        p.sendMessage("§8» §cTEAMSPEAK3: §7ts-fajny.pl");
        p.sendMessage("§8» §cITEMSHOP: §7www.bapehc.pl/offer");
        p.sendMessage("§8» §cNajlepszy hosting: www.cudihosting.pl");
        return false;
    }
}
