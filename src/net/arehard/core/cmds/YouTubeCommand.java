package net.arehard.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.ChatUtil.YoutubeChecker;
import net.arehard.core.config.Config;
import net.arehard.core.yaml.Reklamy;
import net.arehard.core.yaml.Result;

public class YouTubeCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Tylko gracze moga uzywac tej komendy!");
            return true;
        }
        final Player p = (Player)commandSender;
        if (strings.length == 0) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cPoprawne uzycie: /yt <link>"));
            p.sendMessage(ChatUtil.sendMsg("&4Przyklad: &chttps://www.youtube.com/watch?v=9TxkdMhYXcI"));
            return true;
        }
        if (Reklamy.getPlayersReklama(p.getName()) != null) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cJuz posiadasz reklame!"));
            return true;
        }
        final String link = strings[0];
        if (link.split("=").length < 1 && link.split("=").length > 2) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cNiepoprawny link!"));
            return true;
        }
        final String firstLink = link.split("=")[0].toLowerCase();
        if (!firstLink.equals("https://www.youtube.com/watch?v")) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cNiepoprawny link!"));
            return true;
        }
        if (Reklamy.isReklamaUsed(link)) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cTa reklama juz zostala uzyta!"));
            return true;
        }
        final String youtubeId = link.split("=")[1];
        final Result r = YoutubeChecker.getVideoInfo(youtubeId);
        if (r == null) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cCos poszlo nie tak! Sproboj ponownie pozniej"));
            return true;
        }
        if (!r.getTitle().contains(Config.title)) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cTytul filmu musi zawierac wiadomosc &7" + Config.title));
            return true;
        }
        final int subCount = YoutubeChecker.getChannelSubs(r.getChannelID());
        if (subCount == -1) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cCos poszlo nie tak! Sproboj ponownie pozniej"));
            return true;
        }
        if (subCount < Config.iloscSubskrybcji) {
            p.sendMessage(ChatUtil.sendMsg("&4Blad: &cMusisz posiadac wiecej niz &7" + Config.iloscSubskrybcji + " &csubow!"));
            return true;
        }
        Bukkit.broadcastMessage(ChatUtil.translate(Config.ytMsg.replace("%player%", p.getName())));
        p.sendMessage(ChatUtil.sendMsg(Config.validMsg));
        Reklamy.uploadReklama(p.getName(), link);
        Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), Config.completeCmd.replace("%player%", p.getName()));
        return true;
    }
}
