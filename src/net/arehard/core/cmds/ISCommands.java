package net.arehard.core.cmds;

import net.arehard.core.ChatUtil.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ISCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("arehard.core.itemshop")) {
        	commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz uprawien (arehard.core.itemshop)"));
            return false;
        }
        if(strings.length < 1){
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: &7/is <nick> <usluga>"));
            return false;
        }
        if(strings.length < 2){
        	commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPodaj usluge!"));
            return false;
        }
        if(strings[1].equalsIgnoreCase("vip")){
            ChatUtil.sendTitle(Bukkit.getOnlinePlayers(), "&4ITEMSHOP", "&7Uzytkownik &c" + strings[0] + " &7zakupil range &6vip ");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set vip");
            return true;
        }
        if(strings[1].equalsIgnoreCase("sponsor")){
        	ChatUtil.sendTitle(Bukkit.getOnlinePlayers(), "&4ITEMSHOP", "&7Uzytkownik &c" + strings[0] + " &7zakupil range &5sponsor ");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set sponsor");
            return true;
        }
        return false;
    }
}
