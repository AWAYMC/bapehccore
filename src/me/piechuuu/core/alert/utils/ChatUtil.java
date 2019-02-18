package me.piechuuu.core.alert.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

public class ChatUtil {

    public static String fixColor(final String t) {
        return t.replace("&", "§").replace(">>", "»").replace("<<", "«");
    }

    public static Boolean sendMessage(final Player p, final String m) {
        p.sendMessage(fixColor(m));
        return false;
    }

    public static Boolean sendMessage(final CommandSender s, final String m) {
        s.sendMessage(fixColor(m));
        return false;
    }

    @SuppressWarnings("deprecation")
    public static Boolean sendTitle(final Player p, final String t, final String s) {
        p.sendTitle(fixColor(t), fixColor(s));
        return false;
    }

    public static Boolean sendMessage(final Collection<? extends Player> p, final String m) {
        p.stream().forEach(cp -> sendMessage(cp, fixColor(m)));
        return false;
    }

    public static Boolean sendTitle(final Collection<? extends Player> p, final String t, final String s) {
        p.stream().forEach(cp -> sendTitle(cp, t, s));
        return false;
    }

    public static Boolean sendActionBar(final Player p, final String m) {
        final IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + fixColor(m) + "\"}");
        final PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
        return false;
    }

    public static Boolean sendActionBar(final Collection<? extends Player> p, final String m) {
        p.stream().forEach(cp -> sendActionBar(cp, m));
        return false;
    }
}

