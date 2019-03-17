package net.arehard.core.cmds;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VipCommands implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            for (final String m : Config.SETTINGS_VIP) {
                ChatUtil.sendMsg(p, m.replace("{NICK}", p.getName()));
                return false;
            }

        }
        else {
            sender.sendMessage("§cNie mozesz tego wykonac z poziomu konsoli!");
        }
        return false;
    }
}
