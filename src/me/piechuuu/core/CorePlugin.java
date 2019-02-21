package me.piechuuu.core;
import me.piechuuu.core.commands.*;
import me.piechuuu.core.listener.*;
import me.piechuuu.core.managers.FileManager;
import me.piechuuu.core.managers.TpPlayer;
import me.piechuuu.core.tasks.AutoMessageTask;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class CorePlugin extends JavaPlugin {

    // /sethome
    // /home
    // /setspawn
    // /spawn
    // /efekty
    // /msg
    // /helpop
    // https://www.youtube.com/watch?v=EJtzAC1wpmo przydatne poradniki

    public static CorePlugin instance;

    public static CorePlugin getInstance() {
        return instance;
    }

    private static CorePlugin inst;
    public static String prefix = "§cBAPE§4HC §8»"; // prefix serwerowy
    private static CorePlugin plugin;
    public static BukkitTask task;
    public static CorePlugin hook(){
        return instance;
    }

    public static List<String> cmd = new ArrayList<>();

    public Map<UUID, Integer> coinData = new HashMap<UUID, Integer>();


    public void onEnable() {
        getLogger().info("[BapeHC_Core] uruchamianie core..."); // podczas uruchomiania core wiadomosc

        // rejestruje komendy i listenery
        registerCommands();
        registerListeners();

        // tworzy folder "users" i zapisuje "config"
        FileManager.checkFiles();

        new AutoMessageTask(this); // automatyczna wiadomosc na chat
        cmd = inst.getConfig().getStringList("blocked-cmd"); // blokada danej komendy
    }
    private void registerCommands() { // rejstruje getCommand
        getCommand("case").setExecutor(new CaseCommand()); // rozdawanie caseow serwerowi
        getCommand("is").setExecutor(new ItemShopCommand()); // gdy ktos zakupi dany przedmiot
        getCommand("pomoc").setExecutor(new HelpWithCommand()); // informacje o serwerze dostepne komendy
        getCommand("vip").setExecutor(new VipCommand()); // informacje o randze vip
        getCommand("svip").setExecutor(new SvipCommand()); // informacje o randze svip
        getCommand("fly").setExecutor(new FlyCommand()); // mozliwosc latania
        getCommand("god").setExecutor(new GodCommand()); // wlaczanie niesmiertelnosci po przez komende
        getCommand("helper").setExecutor(new HelperCommand()); // informacje o randze helper
        getCommand("mod").setExecutor(new ModeratorCommand()); // informacje o randze moderator
        getCommand("heal").setExecutor(new HealCommand()); // leczenie po przez komende
        getCommand("gm").setExecutor(new GameModeCommand()); // zmiana trybu gry
        getCommand("bc").setExecutor(new BroadCastCommand()); // wysylanie wiadomosci do chatu
        getCommand("chat").setExecutor(new ChatCommand()); // zarzadzanie chatem
        getCommand("tpa").setExecutor(new TpaCommand()); // wysylanie prosby o teleportacje do danego gracza
        getCommand("tpaccept").setExecutor(new TpAcceptCommand()); // akceptowanie teleportacji od danego gracza
        getCommand("tpdeny").setExecutor(new TpDenyCommand()); // anulowanie teleportacja od danego gracza
        getCommand("tp").setExecutor(new TpPlayer()); // teleportacja do danego gracza
        getCommand("zamowienie").setExecutor(new ZamowienieCommand()); // lista zamowien
        getCommand("kick").setExecutor(new KickCommand()); // wyrzucanie gracza z serwera
        getCommand("alert").setExecutor(new AlertCommand()); // wysylanie alertow na chat
        getCommand("kit").setExecutor(new KitCommand()); // dostepne zestawy
        getCommand("vanish").setExecutor(new VanishCommand()); // znikanie admininstratora
        getCommand("enchant").setExecutor(new EnchantCommand()); // enchantowanie itemow
        getCommand("enchantlist").setExecutor(new EnchantListCommand()); // lista enchantow
        getCommand("sklep").setExecutor(new ShopCommand()); // serwerowy sklep
        getCommand("ban").setExecutor(new BanCommand()); // odpowiada za wiadomosc bana
    }
    private void registerListeners() { // rejstruje listenery
        PluginManager pm = Bukkit.getPluginManager(); // potrzebne do zarejstrowania listenerow
        pm.registerEvents(new AsynPlayerChatListener(), this); // takzwany chat-format
        pm.registerEvents(new CaseDropListener(), this); // drop z caseow
        pm.registerEvents(new CaseKickQuitListener(), this); // wyrzucanie z menu case
        pm.registerEvents(new CasePlaceListener(), this); // stawianie case na ziemie
        pm.registerEvents(new InventoryClickListener(), this); // otwieranie caseow
        pm.registerEvents(new PlayerMoveListener(), this); // teleportacja gracza
        pm.registerEvents(new BlockedCmd(), this); // blokowanie danej komendy
        pm.registerEvents(new PlayerJoinListener(), this); // wiadomosc gdy gracz wejdzie na serwer
        pm.registerEvents(new InvCllickEvent(), this); // inventory sklepu
        pm.registerEvents(new BanListener(), this); // odpowiada zeby gracz po otrzymaniu bana nie mogl wejsc na serwer
    }
    public static CorePlugin getPlugin() {
        return CorePlugin.plugin;
    }
    public void onDisable(){
        getLogger().info("[BapeHC_Core] wylaczanie core..."); // podczas wylaczania core wiadomosc
    }
}
