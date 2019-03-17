package net.arehard.core;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    public void onEnable(){
        registerCommands();
        registerListener();
        getLogger().info("----( AreHardCore )----");
        getLogger().info("» Licencja Zaakceptowana...");
        getLogger().info("» Uruchamianie core...");
        getLogger().info("» Autorzy: Adrianekk, Piechuuu");
        getLogger().info("» Wersja: 0.1");
        getLogger().info("» Mysql: 0.5");
        getLogger().info("» Proxy: 0.3");
        getLogger().info("----( AreHardCore )----");
    }

    private void registerListener() {
    }

    private void registerCommands() {
    }

    public void onDisable() {
        getLogger().info("----( AreHardCore )----");
        getLogger().info("» Wylaczanie core...");
        getLogger().info("» Autorzy: Adrianekk, Piechuuu");
        getLogger().info("» Wersja: 0.1");
        getLogger().info("» Mysql: 0.5");
        getLogger().info("» Proxy: 0.3");
        getLogger().info("----( AreHardCore )----");
    }
}
