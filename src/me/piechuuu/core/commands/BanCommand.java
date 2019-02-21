package me.piechuuu.core.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class BanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if (!commandSender.hasPermission("bapehc.core.ban")) {
            TitleAPI.sendTitle(p, 20, 50, 20, "§4Blad:", "§8» §cNie masz dostepu do tej komendy");
            return false;
        }
        if (strings.length < 1) {
            TitleAPI.sendTitle(p, 20, 50, 20, "§4§lBAN", "§8» §c/ban <nick> <powod> ");
            return false;
        }
        try{
            this.BanPlayer(strings[0]);
        }catch (IOException e){
            TitleAPI.sendTitle(p, 20, 50, 20, "§4§lBAN", "§8» §cNie znalezniono sciezki ");
            e.printStackTrace();
        }
        return false;
    }

    public void BanPlayer(String playername) throws IOException {
        File file = new File("plugins//BAPEHC_CORE//userdata//" + playername + ".yml");
        if (!file.exists()) {
            file.createNewFile();
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("banned", "true");
        cfg.save(file);

        Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
        for(int i = 0; i < players.length; i++){
            Player z = players[i];
            if(z.getName().equals(playername)){
                z.kickPlayer("§4§lBAN");
                z.kickPlayer("§czostales zbanowany");
                z.kickPlayer("§cPrzez: §7" + z.getName());
                z.kickPlayer("§cPowod: §7");
                z.sendMessage(new StringBuilder().append(ChatColor.GRAY).append("§cZbanowales gracza").append(z.getName()).toString());
                Bukkit.broadcastMessage("");
            }
        }
    }
}
