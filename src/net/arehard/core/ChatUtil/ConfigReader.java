package net.arehard.core.ChatUtil;

import org.bukkit.plugin.java.*;
import java.io.*;
import org.bukkit.configuration.file.*;

public class ConfigReader
{
    private FileConfiguration fc;
    private File file;
    private final JavaPlugin plugin;
    private static ConfigReader config;
    private final String filename;
    
    public ConfigReader(final String filename) {
        this.plugin = JavaPlugin.getProvidingPlugin(this.getClass());
        this.filename = filename;
        ConfigReader.config = this;
    }
    
    public JavaPlugin getInstance() {
        if (this.plugin == null) {
            try {
                throw new Exception();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.plugin;
    }
    
    public boolean delete() {
        return this.getFile().delete();
    }
    
    public boolean exists() {
        if (this.fc == null || this.file == null) {
            final File temp = new File(this.getDataFolder(), this.filename);
            if (!temp.exists()) {
                return false;
            }
            this.file = temp;
        }
        return true;
    }
    
    public File getDataFolder() {
        final File dir = new File(ConfigReader.class.getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("%20", " "));
        final File d = new File(dir.getParentFile().getPath(), this.getInstance().getName());
        if (!d.exists()) {
            d.mkdirs();
        }
        return d;
    }
    
    public File getFile() {
        if (this.file == null) {
            this.file = new File(this.getDataFolder(), this.filename);
            if (!this.file.exists()) {
                try {
                    this.file.createNewFile();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.file;
    }
    
    public FileConfiguration getConfig() {
        if (this.fc == null) {
            this.fc = (FileConfiguration)YamlConfiguration.loadConfiguration(this.getFile());
        }
        return this.fc;
    }
    
    public void saveDefaultConfig() {
        this.plugin.saveResource(this.filename, false);
    }
    
    public void reload() {
        if (this.file == null) {
            this.file = new File(this.getDataFolder(), this.filename);
            if (!this.file.exists()) {
                try {
                    this.file.createNewFile();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.fc = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
        }
    }
    
    public void resetConfig() {
        this.delete();
        this.getConfig();
    }
    
    public void saveConfig() {
        try {
            this.getConfig().save(this.getFile());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
