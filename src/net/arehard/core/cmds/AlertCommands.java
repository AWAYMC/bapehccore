package net.arehard.core.cmds;

import com.connorlinfoot.titleapi.TitleAPI;
import net.arehard.core.ChatUtil.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlertCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if(!commandSender.hasPermission("alert.pvp.core")){
            TitleAPI.sendTitle(p,20,50,20, ChatUtil.fixColor("&4Blad:"),ChatUtil.fixColor("&8>> &cNie masz dostepu do &7(alert.pvp.core)"));
            return false;
        }
        if(strings.length < 1){
            commandSender.sendMessage(ChatUtil.fixColor("&8>> &4Blad: &cPoprawne uzycie: &7/alert <title|subtitle|chat> <wiadomosc>"));
            return false;
        }
        if(strings.length < 2){
            commandSender.sendMessage(ChatUtil.fixColor("&8>> &4Blad: &cWybierz proporcje!"));
        }

        return false;
    }
}
