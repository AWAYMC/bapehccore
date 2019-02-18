package me.piechuuu.core.listener;

import me.piechuuu.core.chatutils.ChatUtil;
import me.piechuuu.core.managers.ChatManager;
import me.piechuuu.core.managers.PexManager;
import net.dzikoysk.funnyguilds.basic.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsynPlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (!ChatManager.isEnabled() && !event.getPlayer().hasPermission("neonhc.core.chat")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatUtil.fixColor("&4Blad: &cChat jest aktualnie wylaczony!"));
            return;
        }
        Long chat = ChatManager.getChatTimerMap().get(event.getPlayer());
        if (chat != null && chat > System.currentTimeMillis() && !event.getPlayer().hasPermission("neonhc.core.chat")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatUtil.fixColor("&4Blad: &cPoczekaj 3 sekundy przed nastepna wiadomoscia!"));
            return;
        }
        User user = User.get(event.getPlayer());
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("gracz")) {
            event.setFormat(ChatUtil.fixColor((user.hasGuild() ? "&8[&f" + user.getGuild().getTag() + "] " : "") + "&8[&f" + user.getRank().getPoints() + "&8] &7%1$s&8: &7%2$s"));
        }
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("vip")) {
            event.setFormat(ChatUtil.fixColor((user.hasGuild() ? "&8[&f" + user.getGuild().getTag() + "] " : "") + "&8[&f" + user.getRank().getPoints() + "&8] &6VIP &7%1$s&8: &7%2$s"));
            event.setMessage(ChatUtil.fixColor(event.getMessage()));
        }
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("svip")) {
            event.setFormat(ChatUtil.fixColor((user.hasGuild() ? "&8[&f" + user.getGuild().getTag() + "] " : "") + "&8[&f" + user.getRank().getPoints() + "&8] &5S&6VIP &7%1$s&8: &7%2$s"));
            event.setMessage(ChatUtil.fixColor(event.getMessage()));
        }
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("yt")) {
            event.setFormat(ChatUtil.fixColor((user.hasGuild() ? "&8[&f" + user.getGuild().getTag() + "] " : "") + "&8[&f" + user.getRank().getPoints() + "&8] &fY&cT &7%1$s&8: &7%2$s"));
            event.setMessage(ChatUtil.fixColor(event.getMessage()));
        }
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("helper")) {
            event.setFormat(ChatUtil.fixColor("&3HELPER &7%1$s&8: &b%2$s"));
            event.setMessage(ChatUtil.fixColor(event.getMessage()));
        }
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("mod")) {
            event.setFormat(ChatUtil.fixColor("&2MOD &7%1$s&8: &2%2$s"));
            event.setMessage(ChatUtil.fixColor(event.getMessage()));
        }
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("admin")) {
            event.setFormat(ChatUtil.fixColor("&cADMIN &7%1$s&8: &4%2$s"));
            event.setMessage(ChatUtil.fixColor(event.getMessage()));
        }
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("headadmin")) {
            event.setFormat(ChatUtil.fixColor("&4HEADADMIN &7%1$s&8: &c%2$s"));
            event.setMessage(ChatUtil.fixColor(event.getMessage()));
        }
        if (PexManager.getGroupName(event.getPlayer()).equalsIgnoreCase("ceo")) {
            event.setFormat(ChatUtil.fixColor("&4CEO &7%1$s&8: &c%2$s"));
            event.setMessage(ChatUtil.fixColor(event.getMessage()));
        }
        ChatManager.getChatTimerMap().put(event.getPlayer(), System.currentTimeMillis() + 3000L);
    }
}


