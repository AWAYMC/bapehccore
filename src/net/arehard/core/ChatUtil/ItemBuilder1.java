package net.arehard.core.ChatUtil;

import org.bukkit.enchantments.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import java.util.*;

public class ItemBuilder1
{
    private Material mat;
    private int amount;
    private final short data;
    private String title;
    private final List<String> lore;
    private final HashMap<Enchantment, Integer> enchants;
    private Color color;
    private Potion potion;
    
    public ItemBuilder1(final Material mat) {
        this(mat, 1);
    }
    
    public ItemBuilder1(final Material mat, final int amount) {
        this(mat, amount, (short)0);
    }
    
    public ItemBuilder1(final Material mat, final short data) {
        this(mat, 1, data);
    }
    
    public ItemBuilder1(final Material mat, final int amount, final short data) {
        this.title = null;
        this.lore = new ArrayList<String>();
        this.enchants = new HashMap<Enchantment, Integer>();
        this.mat = mat;
        this.amount = amount;
        this.data = data;
    }
    
    public ItemBuilder1 setType(final Material mat) {
        this.mat = mat;
        return this;
    }
    
    public ItemBuilder1 setTitle(final String title) {
        this.title = title;
        return this;
    }
    
    public ItemBuilder1 addLores(final List<String> lores) {
        this.lore.addAll(lores);
        return this;
    }
    
    public ItemBuilder1 addLore(final String lore) {
        this.lore.add(lore);
        return this;
    }
    
    public ItemBuilder1 addEnchantment(final Enchantment enchant, final int level) {
        if (this.enchants.containsKey(enchant)) {
            this.enchants.remove(enchant);
        }
        this.enchants.put(enchant, level);
        return this;
    }
    
    public ItemBuilder1 setAmount(final int amount) {
        this.amount = amount;
        return this;
    }
    
    public ItemStack build() {
        Material mat = this.mat;
        if (mat == null) {
            mat = Material.AIR;
            Bukkit.getLogger().warning("Null material!");
        }
        final ItemStack item = new ItemStack(this.mat, this.amount, this.data);
        final ItemMeta meta = item.getItemMeta();
        if (this.title != null) {
            meta.setDisplayName(this.title);
        }
        if (!this.lore.isEmpty()) {
            meta.setLore((List)this.lore);
        }
        if (meta instanceof LeatherArmorMeta) {
            ((LeatherArmorMeta)meta).setColor(this.color);
        }
        item.setItemMeta(meta);
        item.addUnsafeEnchantments((Map)this.enchants);
        if (this.potion != null) {
            this.potion.apply(item);
        }
        return item;
    }
    
    public Material getType() {
        return this.mat;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public List<String> getLore() {
        return this.lore;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public boolean hasEnchantment(final Enchantment enchant) {
        return this.enchants.containsKey(enchant);
    }
    
    public int getEnchantmentLevel(final Enchantment enchant) {
        return this.enchants.get(enchant);
    }
    
    public HashMap<Enchantment, Integer> getAllEnchantments() {
        return this.enchants;
    }
    
    public boolean isItem(final ItemStack item) {
        return this.isItem(item, false);
    }
    
    public boolean isItem(final ItemStack item, final boolean strictDataMatch) {
        final ItemMeta meta = item.getItemMeta();
        if (item.getType() != this.getType()) {
            return false;
        }
        if (!meta.hasDisplayName() && this.getTitle() != null) {
            return false;
        }
        if (!meta.getDisplayName().equals(this.getTitle())) {
            return false;
        }
        if (!meta.hasLore() && !this.getLore().isEmpty()) {
            return false;
        }
        if (meta.hasLore()) {
            for (final String lore : meta.getLore()) {
                if (!this.getLore().contains(lore)) {
                    return false;
                }
            }
        }
        for (final Enchantment enchant : item.getEnchantments().keySet()) {
            if (!this.hasEnchantment(enchant)) {
                return false;
            }
        }
        return true;
    }
}
