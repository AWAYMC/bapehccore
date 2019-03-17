package net.arehard.core.cmds;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VipCommands implements CommandExecutor {

    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
        if (commandSender instanceof Player) {
            final Player p = (Player) commandSender;
            for (final String m : Config.SETTINGS_VIP) {
                ChatUtil.sendMsg((CommandSender) p, m.replace("{NICK}", p.getName()));
                return false;
            }
        } else{
            commandSender.sendMessage("xd");
        }
        return false;
    }
}