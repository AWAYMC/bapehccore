package net.arehard.core.cmds;


import net.arehard.core.ChatUtil.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class AlertCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("arehard.core.alert")){
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz uprawien (arehard.core.alert)"));
            return false;
        }
        if(strings.length < 1){
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: /alert <title/subtitle/chat> <wiadomosc>"));
            return false;
        }
        if(strings.length < 2){
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cWybierz proporcje!"));
        }

        return false;
    }
}
