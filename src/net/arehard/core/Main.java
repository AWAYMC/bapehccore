package net.arehard.core;

import net.arehard.core.cmds.*;
import net.arehard.core.config.Config;
import net.arehard.core.listeners.AsyncPlayerChatListener;
import net.arehard.core.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private static Main inst;

    public void onEnable(){
<<<<<<< HEAD
        regCom();
        regEvents();
    public void onEnable() {
=======
        registerListener();
>>>>>>> cf9d443b4f56daab43ba4cc5dfb47e7cdeae4ab0
        registerCommands();
        registerListener();
        getLogger().info("----( AreHardOnEnable )----");
        getLogger().info("» Licencja Zaakceptowana...");
        getLogger().info("» Uruchamianie core...");
        getLogger().info("» Autorzy: Adrianekk, Piechuuu");
        getLogger().info("» Wersja: 0.1");
        getLogger().info("» Mysql: 0.5");
        getLogger().info("» Proxy: 0.3");
        getLogger().info("----( AreHardOnEnable )----");
        Config.reloadConfig();
    }


<<<<<<< HEAD
    private void regEvents() {

=======
>>>>>>> cf9d443b4f56daab43ba4cc5dfb47e7cdeae4ab0
    private void registerListener() {
        getLogger().info("----( AreHardListeners )----");
        getLogger().info("» Wczytuje listenery...");
        getLogger().info("----( AreHardListeners )----");
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
    }

<<<<<<< HEAD

    private void regCom() {

    private void registerCommands() {

=======
    private void registerCommands() {
>>>>>>> cf9d443b4f56daab43ba4cc5dfb47e7cdeae4ab0
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
