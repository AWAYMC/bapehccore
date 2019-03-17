package net.arehard.core;

import net.arehard.core.cmds.*;
import net.arehard.core.listeners.AsyncPlayerChatListener;
import net.arehard.core.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private static Main inst;

<<<<<<< HEAD
    public void onEnable(){
        regCom();
        regEvents();
=======
    public void onEnable() {
        registerCommands();
        registerListener();
>>>>>>> dfaa53145ea9340d6eabe4b5286f2a7ac6f1eeb5
        getLogger().info("----( AreHardOnEnable )----");
        getLogger().info("» Licencja Zaakceptowana...");
        getLogger().info("» Uruchamianie core...");
        getLogger().info("» Autorzy: Adrianekk, Piechuuu");
        getLogger().info("» Wersja: 0.1");
        getLogger().info("» Mysql: 0.5");
        getLogger().info("» Proxy: 0.3");
        getLogger().info("----( AreHardOnEnable )----");
    }

<<<<<<< HEAD
    private void regEvents() {
=======
    private void registerListener() {
>>>>>>> dfaa53145ea9340d6eabe4b5286f2a7ac6f1eeb5
        getLogger().info("----( AreHardListeners )----");
        getLogger().info("» Wczytuje listenery...");
        getLogger().info("----( AreHardListeners )----");
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
    }

<<<<<<< HEAD
    private void regCom() {
=======
    private void registerCommands() {
>>>>>>> dfaa53145ea9340d6eabe4b5286f2a7ac6f1eeb5
        getLogger().info("----( AreHardCommands )----");
        getLogger().info("» Wczytuje komendy...");
        getLogger().info("----( AreHardCommands )----");
        getCommand("is").setExecutor(new ISCommands());
        getCommand("alert").setExecutor(new AlertCommands());
        getCommand("fly").setExecutor(new FlyCommands());
        getCommand("chat").setExecutor(new ChatCommands());
        getCommand("gm").setExecutor(new GamemodeCommands());
        getCommand("vip").setExecutor(new VipCommands());
        getCommand("sponsor").setExecutor(new SponsorCommands());
    }

    public void onDisable() {
        getLogger().info("----( AreHardOnDisable )----");
        getLogger().info("» Wylaczanie core...");
        getLogger().info("» Autorzy: Adrianekk, Piechuuu");
        getLogger().info("» Wersja: 0.1");
        getLogger().info("» Mysql: 0.5");
        getLogger().info("» Proxy: 0.3");
        getLogger().info("----( AreHardOnDisable )----");
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
