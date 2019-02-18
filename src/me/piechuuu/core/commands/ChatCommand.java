package me.piechuuu.core.commands;

import me.piechuuu.core.chatutils.ChatUtil;
import me.piechuuu.core.managers.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.hasPermission("bapehc.core.chat")) {
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie masz dostepu do &7(bapehc.core.chat)"));
            return true;
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

