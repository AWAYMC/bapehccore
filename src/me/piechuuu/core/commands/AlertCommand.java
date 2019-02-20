package me.piechuuu.core.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import me.piechuuu.core.alert.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlertCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if(!commandSender.hasPermission("bapehc.core.alert")){
            TitleAPI.sendTitle(p,20,50,20,"§4Blad:", "§8» §cNie masz dostepu do tej komendy");
            return false;
        }
        if (strings.length < 2)
            return ChatUtil.sendMessage(commandSender,
                    "&8>> &cPoprawne uzycie: &7/alert <chat/title/subtitle/actionbar> (wiadomosc)");
        String out = "";
        for (int i = 1; i < strings.length; ++i)
            out += strings[i] + " ";
        final String message = out;
        switch (strings[0].toLowerCase()) {
            case "chat":
                return ChatUtil.sendMessage(Bukkit.getOnlinePlayers(), "&8[&4UWAGA&8] &c" + message);
            case "title":
                return ChatUtil.sendTitle(Bukkit.getOnlinePlayers(), "&6" + message, " ");
            case "subtitle":
                return ChatUtil.sendTitle(Bukkit.getOnlinePlayers(), "&8[&4ALERT&8]", "&c" + message);
            case "actionbar":
                return ChatUtil.sendActionBar(Bukkit.getOnlinePlayers(), "&c" + message);
        }
        return false;
    }
}
