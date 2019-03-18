package net.arehard.core.taks;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import net.arehard.core.ChatUtil.YoutubeChecker;
import net.arehard.core.config.Config;
import net.arehard.core.yaml.Reklamy;

public class DeleteTask implements Runnable
{
    @Override
    public void run() {
        for (final String s : Reklamy.getReklamas().keySet()) {
            if (YoutubeChecker.shouldVideoBeDeleted(Reklamy.getPlayersReklama(s).split("=")[1])) {
                Reklamy.removeReklama(s);
                Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), Config.deleteCmd.replace("%player%", s));
            }
        }
    }
}
