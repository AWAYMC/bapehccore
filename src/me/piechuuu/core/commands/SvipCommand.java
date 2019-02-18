package me.piechuuu.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SvipCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("§8§m----------( §5SVIP §8)§m----------");
        commandSender.sendMessage("§8» §cCena: §77.23");
        commandSender.sendMessage("§8» §cCzas trwania: §7Edycja");
        commandSender.sendMessage("§8» §cZakup dostepny: §7www.bapehc.pl/offer");
        commandSender.sendMessage("§8» §cMozliwosci:");
        commandSender.sendMessage("");
        commandSender.sendMessage("§8» §c/kit vip /kit svip §7Dostepny zestaw vip,svip");
        commandSender.sendMessage("§8» §c/wb §7Przenosny crafting");
        commandSender.sendMessage("§8» §c/ec §7Przenosny enderchest");
        commandSender.sendMessage("§8» §cO polowe mniej itemow na gildie");
        commandSender.sendMessage("§8» §cMozliwosc zalozenia nawet dwoch sethome");
        commandSender.sendMessage("§8§m----------( §5SVIP §8)§m----------");
        return false;
    }
}
