package me.piechuuu.core.MagiCaseChatUtil;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class ChatUtil {

	public static String fixColor(String text)
	{
	  return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "�").replace("<<", "�").replace("*", "•").replace("{O}", "�"));
	}	
    public static List<String> fColor(List<String> strings) {
        List<String> colors = new ArrayList<String>();
        for (String s : strings)
            colors.add(fixColor(s));
        return colors;
    }
}
