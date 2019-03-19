package net.arehard.core.cmds;

<<<<<<< HEAD
import net.arehard.core.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VipCommands implements CommandExecutor {

    Main plugin;

    public VipCommands(){
        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        if(!(commandSender instanceof Player)){
            final Player player = (Player) commandSender;
            for(String s : this.plugin.getConfig().getStringList("config.message.vip")){
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
=======
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VipCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		return false;
	}
>>>>>>> 03aa371765292efd413c0f13a2f6d90da118d597
}
