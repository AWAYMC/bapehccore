package me.piechuuu.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ZamowienieCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("§8§m----------§8( §cZAMOWIENIE §8)§m----------");
        commandSender.sendMessage("§8» §7Witaj znalezles sie tutaj poniewaz potrzebujesz autorskiej/autorskiego paczki/core");
        commandSender.sendMessage("§8» §7co nalezy zrobic? wejdz na temaspeak3: §cts-fajny.pl");
        commandSender.sendMessage("§8» §7Nastepnie crtl+f wpisac bapehc.pl znalezc kanal zamowienie cena do uzgodnienia :)");
        commandSender.sendMessage("§8» §7Autorami paczki na twoj serwer jest Piechuuu oraz Dawidos506");
        commandSender.sendMessage("§8§m----------§8( §cZAMOWIENIE §8)§m----------");
        return false;
    }
}
