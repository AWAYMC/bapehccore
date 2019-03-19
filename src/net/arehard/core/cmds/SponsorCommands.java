package net.arehard.core.cmds;

import net.arehard.core.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SponsorCommands implements CommandExecutor {

    Main plugin;

    public SponsorCommands(){
        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        if(!(commandSender instanceof Player)){
            final Player player = (Player) commandSender;
            for(String s : this.plugin.getConfig().getStringList("config.message.sponsor")){
                s = s.replace("&","§");
                s = s.replace(">>","»");
                s = s.replace("<<", "«");
                player.sendMessage(s);
            }
        }
        else{
            commandSender.sendMessage("Nie mozesz wykonac z poziomu konsoli");
        }
        return false;
    }
}

