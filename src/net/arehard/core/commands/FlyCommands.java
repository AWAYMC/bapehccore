package net.arehard.core.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import net.arehard.core.ChatUtil.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Ta komenda nie jest od poziomu konsoli");
            return false;
        }
        if(!commandSender.hasPermission("fly.pvp.core")){
            TitleAPI.sendTitle(p,20,50,20, ChatUtil.fixColor("&4Blad:"),ChatUtil.fixColor("&8>> &cNie masz dostepu do &7(fly.pvp.core)"));
            return false;
        }
        if(strings.length==0){
            p.getAllowFlight()
        }
        return false;
    }
}
