package me.piechuuu.core.listener;

import com.connorlinfoot.titleapi.TitleAPI;
import me.piechuuu.core.managers.FileManager;
import me.piechuuu.core.vanish.utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void joinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        FileManager.createPlayerFile(p);
        for (int i = 0; i < 100; ++i) ;
        p.sendMessage("§7Witaj na serwerze §cBAPE§4HC.PL");
        p.sendMessage("§7Znajdujesz sie §cMedium§4HC");
        p.sendMessage("§7Zyczymy ci milesj gry :)");
        TitleAPI.sendTitle(p,20,50,20,"§cBAPE&4HC.PL", "§8» §7Wiecej pod §c/pomoc :)");
    }
}
