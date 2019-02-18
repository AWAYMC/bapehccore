package me.piechuuu.core;
import me.piechuuu.core.commands.*;
import me.piechuuu.core.listener.*;
import me.piechuuu.core.managers.FileManager;
import me.piechuuu.core.managers.TpPlayer;
import me.piechuuu.core.tasks.AutoMessageTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class CorePlugin extends JavaPlugin {

    // TODO
    // /helpop

    public static CorePlugin instance;

    public static CorePlugin getInstance() {
        return instance;
    }

    private static CorePlugin inst;
    public static String prefix = "§cBAPE§4HC §8»";
    private static CorePlugin plugin;
    public static BukkitTask task;

    public static List<String> cmd = new ArrayList<>();


    public void onEnable() {
        getLogger().info("[BapeHC_Core] uruchamianie core...");

        // rejestruje komendy i listenery
        registerCommands();
        registerListeners();

        // tworzy folder "users" i zapisuje "config"
        FileManager.checkFiles();

        new AutoMessageTask(this);
        cmd = inst.getConfig().getStringList("blocked-cmd");
    }
    private void registerCommands() {
        getCommand("case").setExecutor(new CaseCommand());
        getCommand("is").setExecutor(new ItemShopCommand());
        getCommand("pomoc").setExecutor(new HelpWithCommand());
        getCommand("vip").setExecutor(new VipCommand());
        getCommand("svip").setExecutor(new SvipCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("helper").setExecutor(new HelperCommand());
        getCommand("mod").setExecutor(new ModeratorCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gm").setExecutor(new GameModeCommand());
        getCommand("bc").setExecutor(new BroadCastCommand());
        getCommand("chat").setExecutor(new ChatCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("tpaccept").setExecutor(new TpAcceptCommand());
        getCommand("tpdeny").setExecutor(new TpDenyCommand());
        getCommand("tp").setExecutor(new TpPlayer());
        getCommand("zamowienie").setExecutor(new ZamowienieCommand());
        getCommand("kick").setExecutor(new KickCommand());
    }
    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new AsynPlayerChatListener(), this);
        pm.registerEvents(new CaseDropListener(), this);
        pm.registerEvents(new CaseKickQuitListener(), this);
        pm.registerEvents(new CasePlaceListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);
        pm.registerEvents(new PlayerMoveListener(), this);
        pm.registerEvents(new BlockedCmd(), this);
    }
    public static CorePlugin getPlugin() {
        return CorePlugin.plugin;
    }
    public void onDisable(){
        getLogger().info("[BapeHC_Core] wylaczanie core...");
    }
}
