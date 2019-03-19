package net.arehard.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.ChatUtil.ItemBuilder;
import net.arehard.core.ChatUtil.ItemBuilder1;


public class InventoryClickListener implements Listener{

	@EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        if ((ChatUtil.fixColor("&cMENU &8| &7TRYBOW")).equalsIgnoreCase(event.getInventory().getName())) {
            event.setCancelled(true);
            if (event.getSlot() == 0) {
            	p.closeInventory();
            	p.teleport(Bukkit.getWorld("knockback").getSpawnLocation());
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.setHealth(20);
                p.setFireTicks(0);
                p.setFoodLevel(20);
                for (final PotionEffect effect : p.getActivePotionEffects()) {
                    p.removePotionEffect(effect.getType());
                }
                p.getInventory().setHelmet(new ItemBuilder1(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchantment(Enchantment.DURABILITY, 2).build());
                p.getInventory().setChestplate(new ItemBuilder1(Material.DIAMOND_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchantment(Enchantment.DURABILITY, 2).build());
                p.getInventory().setLeggings(new ItemBuilder1(Material.DIAMOND_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchantment(Enchantment.DURABILITY, 2).build());
                p.getInventory().setBoots(new ItemBuilder1(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchantment(Enchantment.DURABILITY, 2).build());
                p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 5).addEnchantment(Enchantment.FIRE_ASPECT, 2).build() });
                p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.DIAMOND_SWORD).addEnchantment(Enchantment.KNOCKBACK, 2).build() });
                if (p.hasPermission("arehard.core.pvp.vip")) {
                	p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.GOLDEN_APPLE, 3, (short)1).setTitle(ChatUtil.fixColor("KOX")).build() });
                	p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.GOLDEN_APPLE, 15).setTitle(ChatUtil.fixColor("KOX")).build() });
                }
                else {
                	 p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.GOLDEN_APPLE, 2, (short)1).setTitle(ChatUtil.fixColor("KOX")).build() });
                	 p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.GOLDEN_APPLE, 10).setTitle(ChatUtil.fixColor("KOX")).build() });
                }
                p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.FISHING_ROD).build() });
                p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.COOKED_BEEF, 64).build() });
                p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.COBBLESTONE, 64).build() });
                p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.WATER_BUCKET).build() });
                p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.DIAMOND_PICKAXE).addEnchantment(Enchantment.DIG_SPEED, 5).build() });
                p.getInventory().addItem(new ItemStack[] { new ItemBuilder1(Material.ENDER_PEARL, 2).build() });
                return;
            }
        }
        if ((ChatUtil.fixColor("&cAdministracja")).equalsIgnoreCase(event.getInventory().getName())) {
            event.setCancelled(true);
            if (event.getSlot() == 0) {
            	event.setCancelled(true);
            }
            if (event.getSlot() == 1) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 2) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 3) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 4) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 5) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 6) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 7) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 8) {
            	event.setCancelled(true);
            } 
            if (event.getSlot() == 9) {
            	event.setCancelled(true);
            } 
        }
    }
}