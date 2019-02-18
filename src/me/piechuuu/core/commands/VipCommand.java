package me.piechuuu.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VipCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("§8» §cCena: §7.23");
        commandSender.sendMessage("§8» §cCzas trwania: §7Edycja");
        commandSender.sendMessage("§8» §cZakup dostepny: §7www.bapehc.pl/offer");
        commandSender.sendMessage("§8» §cMozliwosci:");
        commandSender.sendMessage("");
        commandSender.sendMessage("§8» §c/kit vip §7Dostepny zestaw vip");
        commandSender.sendMessage("§8» §c/wb §7Przenosny crafting");
        commandSender.sendMessage("§8» §c/ec §7Przenosny enderchest");
        commandSender.sendMessage("§8» §cO polowe mniej itemow na gildie");
        commandSender.sendMessage("§8» §cMozliwosc zalozenia nawet dwoch sethome");
        return false;
    }
}
