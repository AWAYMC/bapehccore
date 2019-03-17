package net.arehard.core.cmds;

import net.arehard.core.ChatUtil.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommands implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Ta komenda nie jest dla konsoli");
            return false;
        }
        if (!commandSender.hasPermission("arehard.core.heal")) {
        	commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz uprawien (arehard.core.heal)"));
            return false;
        }
        if(strings.length==0){
            p.setHealth(20);
            p.setFoodLevel(20);
            p.setFireTicks(0);
            p.sendMessage(ChatUtil.fixColor("&8>> &7Zostales uleczony!"));
            return true;
        }
        if(strings.length==1) {
            Player cel = Bukkit.getPlayerExact(strings[0]);
            if (cel != null) {
                cel.setHealth(20);
                cel.setFoodLevel(20);
                cel.setFireTicks(0);
                cel.sendMessage(ChatUtil.fixColor("&8>> &7Zostales uleczony przez &c" + commandSender.getName()));
                commandSender.sendMessage(ChatUtil.fixColor("&8>> &7Uleczyles uzytkownika &c" + cel.getName()));
                return true;
            } else {
                commandSender.sendMessage(ChatUtil.fixColor("&8>> &4Blad: &cTen gracz jest OFFLINE!"));
                return false;
            }
        }else{
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: /heal <nick>"));
            return false;
        }
    }
}
