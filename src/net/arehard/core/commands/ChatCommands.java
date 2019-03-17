package net.arehard.core.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.managers.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if (!commandSender.hasPermission("chat.pvp.core")) {
            TitleAPI.sendTitle(p, 20, 50, 20, ChatUtil.fixColor("&4Blad:"), ChatUtil.fixColor("&8>> &cNie masz dostepu do &7(chat.pvp.core)"));
            return false;
        }
        if (strings.length == 0) {
            commandSender.sendMessage(ChatUtil.fixColor("&8>> &7Poprawne uzycie: &3/chat (on|off|cc)"));
            return true;
        }
        switch (strings[0].toLowerCase()) {
            case "wyczysc":
            case "clear":
            case "cc": {
                for (int i = 0; i < 100; ++i) Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Chat zostal wyczyszczony!"));
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Przez: &3" + commandSender.getName() + "!"));
                return true;
            }
            case "wylacz":
            case "off": {
                if (!ChatManager.isEnabled()) {
                    commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cChat jest juz wylaczony!"));
                    return true;
                }
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Chat zostal wylaczony!"));
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Przez: &3" + commandSender.getName() + "!"));
                ChatManager.setEnabled(false);
                return true;
            }
            case "wlacz":
            case "on": {
                if (ChatManager.isEnabled()) {
                    commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cChat jest juz wlaczony!"));
                    return true;
                }
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Chat zostal wlaczony!"));
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Przez: &3" + commandSender.getName() + "!"));
                ChatManager.setEnabled(true);
                return true;
            }
        }
        return false;
    }
}
