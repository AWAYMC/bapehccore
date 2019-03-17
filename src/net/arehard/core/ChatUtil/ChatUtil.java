package net.arehard.core.ChatUtil;

import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtil {

    public static String fixColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»").replace("<<", "«"));
    }
    public static boolean sendMsg(final CommandSender sender, final String message) {
        if (sender instanceof Player) {
            if (message != null || message != "") {
                sender.sendMessage(fixColor(message));
            }
        }
        else {
            sender.sendMessage(ChatColor.stripColor(fixColor(message)));
        }
        return true;
    }


}