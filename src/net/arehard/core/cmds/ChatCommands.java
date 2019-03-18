package net.arehard.core.cmds;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.managers.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.hasPermission("arehard.core.chat")) {
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz uprawien (arehard.core.chat)"));
            return false;
        }
        if (strings.length == 0) {
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: /chat <on/off/cc>"));
            return true;
        }
        switch (strings[0].toLowerCase()) {
            case "wyczysc":
            case "clear":
            case "cc": {
                for (int i = 0; i < 100; ++i) Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Chat zostal wyczyszczony!"));
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Przez: &c" + commandSender.getName() + "!"));
                return true;
            }
            case "wylacz":
            case "off": {
                if (!ChatManager.isEnabled()) {
                    commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cChat jest juz wylaczony!"));
                    return true;
                }
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Chat zostal wylaczony!"));
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Przez: &c" + commandSender.getName() + "!"));
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
                Bukkit.broadcastMessage(ChatUtil.fixColor("&8>> &7Przez: &c" + commandSender.getName() + "!"));
                ChatManager.setEnabled(true);
                return true;
            }
        }
        return false;
    }
}
