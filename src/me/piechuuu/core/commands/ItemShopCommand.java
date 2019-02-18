package me.piechuuu.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ItemShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("bapehc.core.is")){
            commandSender.sendMessage("§4Blad: §cNie masz dostepu do §7(bapehc.core.is)");
            return false;
        }
        if(strings.length < 1){
            commandSender.sendMessage("§4Blad: §cPoprawne uzcyie: §7/is <nick> <vip|svip>");
            return false;
        }
        if(strings[1].equalsIgnoreCase("vip")){
            Bukkit.broadcastMessage("§8§m----------( §cZAKUP §8)§m---------- ");
            Bukkit.broadcastMessage("§8» §7Uzytkownik §c" + strings[0] + " §7zakupil range §6vip");
            Bukkit.broadcastMessage("§8» §7Dziekujemy za wspracie na §cwww.bapehc.pl/offer :)");
            Bukkit.broadcastMessage("§8§m----------( §cZAKUP §8)§m---------- ");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set vip");
            return true;
        }
        if(strings[1].equalsIgnoreCase("svip")) {
            Bukkit.broadcastMessage("§8§m----------( §cZAKUP §8)§m---------- ");
            Bukkit.broadcastMessage("§8» §7Uzytkownik §c" + strings[0] + " §7zakupil range §5svip");
            Bukkit.broadcastMessage("§8» §7Dziekujemy za wspracie na §cwww.bapehc.pl/offer :)");
            Bukkit.broadcastMessage("§8§m----------( §cZAKUP §8)§m---------- ");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set svip");
            return true;
        }
        if(strings[1].equalsIgnoreCase("yt")) {
            Bukkit.broadcastMessage("§8§m----------( §cY§fT §8)§m---------- ");
            Bukkit.broadcastMessage("§8» §7Uzytkownik §c" + strings[0] + "otrzymal range §7 §cy§ft");
            Bukkit.broadcastMessage("§8» §7Powitajmy nowego §cyou§ftubera");
            Bukkit.broadcastMessage("§8§m----------( §cY§fT §8)§m---------- ");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set yt");
            return true;
        }
        return false;
    }
}
