package net.arehard.core.cmds;

import com.connorlinfoot.titleapi.TitleAPI;
import net.arehard.core.ChatUtil.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ISCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if(!commandSender.hasPermission("arehard.core.itemshop")) {
        	commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz uprawien (arehard.core.itemshop)"));
            return false;
        }
        if(strings.length < 1){
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: /is <nick> <usluga>"));
            return false;
        }
        if(strings.length < 2){
        	commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPodaj usluge!"));
            return false;
        }
        if(strings[1].equalsIgnoreCase("vip")){
            TitleAPI.sendFullTitle(p,20,50,20,ChatUtil.fixColor("&cITEMSHOP"),ChatUtil.fixColor("&7Gracz &c" + strings[0] + ChatUtil.fixColor(" &7zakupil range &cVIP")));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set vip");
            return true;
        }
        if(strings[1].equalsIgnoreCase("sponsor")){
            TitleAPI.sendFullTitle(p,20,50,20,ChatUtil.fixColor("&cITEMSHOP"),ChatUtil.fixColor("&7Gracz &c" + strings[0] + ChatUtil.fixColor(" &7zakupil range &cSPONSOR")));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set sponsor");
            return true;
        }
        return false;
    }
}
