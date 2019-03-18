package net.arehard.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.ChatUtil.CoinsUtil;

public class ACoinsCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    	Player p = (Player) commandSender;
        if (!commandSender.hasPermission("arehard.core.acoins")) {
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz uprawien (arehard.core.acoins)"));
            return false;
        }
        if (strings.length == 0) {
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: /acoins <amount> <nick>"));
            return false;
        }
        if(strings.length == 1) {
        	CoinsUtil.CoinsP(p, Integer.parseInt(strings[0]));
        	commandSender.sendMessage(ChatUtil.fixColor("&8>> &7Dodales sobie &c" + strings[0] + " &7coinsow!"));
        	return false;
        }
        if(strings.length == 2) {
        	@SuppressWarnings("deprecation")
			final Player o = Bukkit.getPlayerExact(strings[0]);
            if (o == null) {
                commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cGracz jest OFFLINE!"));
                return true;
            } else {
            	CoinsUtil.CoinsP(o, Integer.parseInt(strings[0]));
            	o.sendMessage(ChatUtil.fixColor("&8>> &7Dostales " + strings[0] + " &coinsow &7od administratora!"));
            	p.sendMessage(ChatUtil.fixColor("&8>> &7Dales graczowi &c" + strings[1] + " &c" + strings[0] + " &7coinsow!"));
            	return false;
            }
            
        }
        return false;
    }
}