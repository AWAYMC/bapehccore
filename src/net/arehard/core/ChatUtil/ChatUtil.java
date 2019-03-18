package net.arehard.core.ChatUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ChatUtil {

		public static String fixColor(final String t) {
			return t.replace("&", "§").replace(">>", "»").replace("<<", "«");
		}
		
		public static Boolean sendMessage(final Player p, final String m) {
			p.sendMessage(fixColor(m));
			return false;
		}
		
		public static Boolean sendMessage(final CommandSender s, final String m) {
			s.sendMessage(fixColor(m));
			return false;
		}
		
		@SuppressWarnings("deprecation")
		public static Boolean sendTitle(final Player p, final String t, final String s) {
			p.sendTitle(fixColor(t), fixColor(s));
			return false;
		}
		
		public static Boolean sendMessage(final Collection<? extends Player> p, final String m) {
			p.stream().forEach(cp -> sendMessage(cp, fixColor(m)));
			return false;
		}
		
		public static Boolean sendTitle(final Collection<? extends Player> p, final String t, final String s) {
			p.stream().forEach(cp -> sendTitle(cp, t, s));
			return false;
		}
		
		public static Boolean sendActionBar(final Player p, final String m) {
		    final IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + fixColor(m) + "\"}");
		    final PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
		    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
		    return false;
		}
		
		public static Boolean sendActionBar(final Collection<? extends Player> p, final String m) {
			p.stream().forEach(cp -> sendActionBar(cp, m));
			return false;
		}

<<<<<<< HEAD
		public static void vanish(Player player, Boolean b, String string) {
			// TODO Auto-generated method stub
			
		}
=======
		public static void giveItems(final Player p, final ItemStack... items) {
	        final Inventory i = (Inventory)p.getInventory();
	        final HashMap<Integer, ItemStack> notStored = (HashMap<Integer, ItemStack>)i.addItem(items);
	        for (final Map.Entry<Integer, ItemStack> e : notStored.entrySet()) {
	            p.getWorld().dropItemNaturally(p.getLocation(), (ItemStack)e.getValue());
	    }
>>>>>>> 4f2e4d7632ba486e801217d912656fdea2c0e1d1
	}
}

