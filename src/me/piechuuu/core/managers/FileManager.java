package me.piechuuu.core.managers;

import me.piechuuu.core.CorePlugin;
import net.dzikoysk.funnyguilds.libs.org.apache.logging.log4j.core.Core;
import org.bukkit.entity.Player;

import java.io.File;

public class FileManager {

    public static File users;

    public static void checkFiles() {
        if(!(CorePlugin.getInstance().getDataFolder().exists())) {
            CorePlugin.getInstance().getDataFolder().mkdir();
        }
        if(!(new File(CorePlugin.getInstance().getDataFolder(), "config.yml").exists())) {
            CorePlugin.getInstance().saveDefaultConfig();
        }
        createUsersFolder();
    }

    public static void createUsersFolder() {
        users = new File(CorePlugin.getInstance().getDataFolder(), "users");
        if(!users.exists()) {
            users.mkdir();
        }
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
