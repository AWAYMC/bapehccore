package me.piechuuu.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelperCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("bapehc.core.helper")){
            commandSender.sendMessage("§8» §4Blad: §cNie masz dostepu do §7(bapehc.core.helper)");
            return false;
        }
        commandSender.sendMessage("§8§m----------( §3HELPER §8)§m----------");
        commandSender.sendMessage("§8» §c/kit vip,svip,admin §7Zestawy ktore posiada ranga §3helper");
        commandSender.sendMessage("§8» §c/tp <nick> §7Teleportacja do danego gracza");
        commandSender.sendMessage("§8» §c/pierozki <ilosc> <gracz|all> §7Rozdawanie pierozka");
        commandSender.sendMessage("§8» §c/tphere <nick> §7Mozliwosc teleportacji gracza do siebie");
        commandSender.sendMessage("§8» §c/sprawdz <nick> <czysty|cheaty|sprawdz> §7Sprawdzanie graczy");
        commandSender.sendMessage("§8» §7Na naszyym serwerze helper ma zakaz zakladania gildii");
        commandSender.sendMessage("§8» §7jezeli taka sytuacja wystapi helper bedzie musial sie tlumaczyc");
        commandSender.sendMessage("§8» §7przed admininstracja wyzsza oraz moze zostac ukrany banem");
        commandSender.sendMessage("§8» §4 pernamentnym");
        commandSender.sendMessage("§8§m----------( §3HELPER §8)§m----------");
        return false;
    }
}
