package net.arehard.core.config;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import org.bukkit.configuration.file.*;
import org.bukkit.configuration.*;
import java.io.*;

public class Config
{
    private static List<RConfig> configs;
    
    static {
        Config.configs = new ArrayList<RConfig>();
    }
    
    public static boolean registerConfig(final String id, final String fileName, final JavaPlugin plugin) {
        final File file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                copy(plugin.getResource(fileName), file);
            }
            catch (Exception ex) {}
        }
        final RConfig c = new RConfig(id, file);
        for (final RConfig x : Config.configs) {
            if (x.equals(c)) {
                return false;
            }
        }
        Config.configs.add(c);
        return true;
    }
    
    public static boolean unregisterConfig(final String id) {
        return Config.configs.remove(getConfig(id));
    }
    
    public static RConfig getConfig(final String id) {
        for (final RConfig c : Config.configs) {
            if (c.getConfigId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
    
    public static boolean save(final String id) {
        final RConfig c = getConfig(id);
        if (c == null) {
            return false;
        }
        try {
            c.save();
        }
        catch (Exception e) {
            print("An error occurred while saving a config with id " + id);
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean saveAll() {
        try {
            for (final RConfig c : Config.configs) {
                c.save();
            }
        }
        catch (Exception e) {
            print("An error occurred while saving all configs");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean load(final String id) {
        final RConfig c = getConfig(id);
        if (c == null) {
            return false;
        }
        try {
            c.load();
        }
        catch (Exception e) {
            print("An error occurred while loading a config with id " + id);
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean loadAll() {
        try {
            for (final RConfig c : Config.configs) {
                c.load();
            }
        }
        catch (Exception e) {
            print("An error occurred while loading all configs");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static void clear(final String id) {
        final RConfig c = getConfig(id);
        if (c == null) {
            return;
        }
        Config.configs.remove(c);
        Config.configs.add(new RConfig(c.getConfigId(), c.getFile()));
    }
    
    private static void print(final String msg) {
        System.out.println("Config: " + msg);
    }
    
    private static void copy(final InputStream in, final File file) throws IOException {
        final OutputStream out = new FileOutputStream(file);
        final byte[] buf = new byte[63];
        while ((in.read(buf)) > 0) {
            final int len2 = 0;
            out.write(buf, 0, len2);
        }
        out.close();
        in.close();
    }
    
    public static class RConfig extends YamlConfiguration
    {
        private String id;
        private File file;
        
        public String getConfigId() {
            return this.id;
        }
        
        public File getFile() {
            return this.file;
        }
        
        private RConfig(final String id, final File file) {
            this.id = id;
            this.file = file;
        }
        
        public void save() throws IOException {
            this.save(this.file);
        }
        
        public void load() throws InvalidConfigurationException, FileNotFoundException, IOException {
            this.load(this.file);
        }
        
        public boolean equals(final RConfig c) {
            return c.getConfigId().equalsIgnoreCase(this.id);
        }
    }
}
