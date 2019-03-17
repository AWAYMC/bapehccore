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
        if(!commandSender.hasPermission("is.pvp.core")) {
            TitleAPI.sendTitle(p, 20, 50, 20, ChatUtil.fixColor("&4Blad:"), ChatUtil.fixColor("&8>> &cNie masz dostepu do &7(is.pvp.core)"));
            return false;
        }
        if(strings.length < 1){
            TitleAPI.sendTitle(p,20,50,20,ChatUtil.fixColor("&4Blad:"), ChatUtil.fixColor("&8>> &cPorawne uzycie: &7/is <nick> <vip,sponsor>"));
            return false;
        }
        if(strings.length < 2){
            TitleAPI.sendTitle(p,20,50,20,ChatUtil.fixColor("&4Blad:"),ChatUtil.fixColor("&7Wybierz usluge!"));
            return false;
        }
        if(strings[1].equalsIgnoreCase("vip")){
            TitleAPI.sendFullTitle(p,20,50,20,ChatUtil.fixColor("&cITEMSHOP"),ChatUtil.fixColor("&7Gracz &c" + strings[0] + ChatUtil.fixColor(" &7zakupil range &6vip")));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set vip");
            return true;
        }
        if(strings[1].equalsIgnoreCase("sponsor")){
            TitleAPI.sendFullTitle(p,20,50,20,ChatUtil.fixColor("&cITEMSHOP"),ChatUtil.fixColor("&7Gracz &c" + strings[0] + ChatUtil.fixColor(" &7zakupil range &5sponsor")));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + strings[0] + " group set sponsor");
            return true;
        }
        return false;
    }
}
