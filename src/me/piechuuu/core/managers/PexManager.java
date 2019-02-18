package me.piechuuu.core.managers;

import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PexManager {

    @SuppressWarnings("deprecation")
    public static String getGroupName(Player player) {
        return PermissionsEx.getUser(player).getGroupNames()[0];
    }
}

