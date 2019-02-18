package me.piechuuu.core.files;

import java.io.File;
import java.util.List;

import me.piechuuu.core.CorePlugin;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	private CorePlugin plugin;
	private List<String> MESSAGES;

	public Config(CorePlugin plugin) {
		this.plugin = plugin;
	}
	
	public List<String> getMessages() {
		return MESSAGES;
	}
	
	public void load() {
		File file = new File(this.plugin.getDataFolder(), "config.yml");
		if (!file.exists()) this.plugin.saveResource("config.yml", true);
		this.MESSAGES = YamlConfiguration.loadConfiguration(file).getStringList("messages");
	}
}
