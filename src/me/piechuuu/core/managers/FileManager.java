package me.piechuuu.core.managers;

import me.piechuuu.core.CorePlugin;
import org.bukkit.entity.Player;

import java.io.File;

public class FileManager {

    public static File users;

    public static void checkFiles() {
        createUsersFolder();
        CorePlugin.getInstance().saveDefaultConfig();
    }

    public static void createUsersFolder() {
        users = new File(CorePlugin.getInstance().getDataFolder(), "users");
        users.mkdir();
    }

    public static void createPlayerFile(Player p) {
        File f = new File(users, p.getName() + ".yml");
        if(f.exists()) return;
        else {
            try {
                f.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
