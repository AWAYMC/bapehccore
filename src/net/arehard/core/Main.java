package net.arehard.core;

import org.bukkit.plugin.java.JavaPlugin;

import net.arehard.core.cmds.ACoinsCommands;
import net.arehard.core.cmds.AlertCommands;
import net.arehard.core.cmds.BanCommands;
import net.arehard.core.cmds.ChatCommands;
import net.arehard.core.cmds.CoinsCommands;
import net.arehard.core.cmds.FlyCommands;
import net.arehard.core.cmds.GamemodeCommands;
import net.arehard.core.cmds.ISCommands;
import net.arehard.core.cmds.KickCommands;
import net.arehard.core.config.Config;
import net.arehard.core.listeners.AsyncPlayerChatListener;
import net.arehard.core.listeners.FoodLevelChangeListener;
import net.arehard.core.listeners.InventoryClickListener;
import net.arehard.core.listeners.PlayerCommandListener;
import net.arehard.core.listeners.PlayerDeathListener;
import net.arehard.core.listeners.PlayerInteractListener;
import net.arehard.core.listeners.PlayerJoinListener;
import net.arehard.core.listeners.WaterPlaceListener;


public class Main extends JavaPlugin {

    private static Main inst;

    public void onEnable(){
        registerCommands();
        registerListener();
        getLogger().info("");
        getLogger().info("----( AreHardOnEnable )----");
        getLogger().info("» Licencja Zaakceptowana...");
        getLogger().info("» Uruchamianie core...");
        getLogger().info("» Autorzy: Adrianekk, Piechuuu");
        getLogger().info("» Wersja: 0.1");
        getLogger().info("» Mysql: 0.5");
        getLogger().info("» Proxy: 0.3");
        getLogger().info("----( AreHardOnEnable )----");
        getLogger().info("");
        getConfig().options().copyDefaults(true);
        saveConfig();
        Config.registerConfig("coins", "coins.yml", this);
        Config.loadAll();
    }


    private void registerListener() {
        getLogger().info("");
        getLogger().info("----( AreHardListeners )----");
        getLogger().info("» Wczytuje listenery...");
        getLogger().info("----( AreHardListeners )----");
        getLogger().info("");
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerCommandListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new WaterPlaceListener(), this);
    }

    private void registerCommands() {
        getLogger().info("");
        getLogger().info("----( AreHardCommands )----");
        getLogger().info("» Wczytuje komendy...");
        getLogger().info("----( AreHardCommands )----");
        getLogger().info("");
        getCommand("is").setExecutor(new ISCommands());
        getCommand("alert").setExecutor(new AlertCommands());
        getCommand("fly").setExecutor(new FlyCommands());
        getCommand("chat").setExecutor(new ChatCommands());
        getCommand("gm").setExecutor(new GamemodeCommands());
        getCommand("coins").setExecutor(new CoinsCommands());
        getCommand("acoins").setExecutor(new ACoinsCommands());
        getCommand("kick").setExecutor(new KickCommands());
        getCommand("ban").setExecutor(new BanCommands());
    }

    public void onDisable() {
        getLogger().info("");
        getLogger().info("----( AreHardOnDisable )----");
        getLogger().info("» Wylaczanie core...");
        getLogger().info("» Autorzy: Adrianekk, Piechuuu");
        getLogger().info("» Wersja: 0.1");
        getLogger().info("» Mysql: 0.5");
        getLogger().info("» Proxy: 0.3");
        getLogger().info("----( AreHardOnDisable )----");
        getLogger().info("");
    }
    public static Main getPlugin() {
        if (Main.inst == null) {
            return new Main();
        }
        return Main.inst;
    }

    public static Main getInst() {
        return Main.inst;
    }

}
