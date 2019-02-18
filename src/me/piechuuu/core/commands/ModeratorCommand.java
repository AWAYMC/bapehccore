package me.piechuuu.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ModeratorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("bapehc.core.moderator")){
            commandSender.sendMessage("§8» §4Blad: §cNie masz dostepu do §7(bapehc.core.moderator)");
            return false;
        }
        commandSender.sendMessage("§8§m----------( §2MODERATOR §8)§m----------");
        commandSender.sendMessage("§8» §c/kit vip,svip,admin §7Dostep do wszystkich zestawow");
        commandSender.sendMessage("§8» §c/tempban <nick> <czas> §7Dostep do banow czasowych");
        commandSender.sendMessage("§8» §c/is <nick> <vip|svip> §7Dostep do nadania rangi vip|svip");
        commandSender.sendMessage("§8» §c/pierozki <nick> <all|gracz> §7Dostep do rozdania pierozkow");
        commandSender.sendMessage("§8» §c/bc <wiadomosc> §7Mozliwosc do alert na caly chat");
        commandSender.sendMessage("§8» §c/chat <cc|on|off> §7Mozliwosc czyszczenia|wlaczenia|wylaczenia chatu");
        commandSender.sendMessage("§8» §c/tphere <nick> §7Mozliwosc teleportacji gracza do siebie");
        commandSender.sendMessage("§8» §c/tp <nick> §7Mozliwosc teleportacji do gracza");
        commandSender.sendMessage("§8» §c/case <case|key> <ilosc> <all|gracz> §7Rozdanie case|key na serwerze");
        commandSender.sendMessage("§8» §c/sprawdz <nick> <czysty|cheaty|sprawdz> §7Sprawdzanie graczy");
        commandSender.sendMessage("§8» §cRanga §2Moderator ma zakaz zakladania gildii na naszym serwerze");
        commandSender.sendMessage("§8» §cjezeli dojdzie do takiej sytuacji §2moderator §cbedzie musial");
        commandSender.sendMessage("§8» §ctlumaczyc sie ze swoich czynow mozna otrzymac rowniez tempbana");
        commandSender.sendMessage("§8» §cdo czasu wyjasnienia tej sprawy");
        commandSender.sendMessage("§8§m----------( §2MODERATOR §8)§m----------");
        return false;
    }
}
