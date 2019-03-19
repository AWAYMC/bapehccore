package net.arehard.core.managers;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatManager {

    private  static boolean enabled;
    private static Map<Player, Long> ChatTimerMap = new ConcurrentHashMap<>();

    public static void setEnabled(boolean enabled){ChatManager.enabled = enabled;}

    public static boolean isEnabled(){return enabled;}

    public static Map<Player,Long> getChatTimeMap(){return ChatTimerMap;}
}
