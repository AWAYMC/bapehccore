package me.piechuuu.core.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import me.piechuuu.core.CorePlugin;
import me.piechuuu.core.MagiCaseChatUtil.ChatUtil;
import me.piechuuu.core.MagiCaseChatUtil.ItemBuilder;
import me.piechuuu.core.MagiCaseChatUtil.PolishItemNames;
import me.piechuuu.core.MagiCaseChatUtil.RandomUtil;
import me.piechuuu.core.data.CaseInv;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class CaseManager {

    private static ConcurrentHashMap<Player, CaseInv> cases;

    public static ItemBuilder key;
    public static ItemBuilder mcase;
    public static List<ItemStack> drop;


    static {
        drop = new ArrayList<>();
        drop.add(new ItemStack(Material.ENDER_PEARL, 2));
        drop.add(new ItemStack(Material.EMERALD_BLOCK, 16));
        drop.add(new ItemStack(Material.GOLDEN_APPLE, 12));
        drop.add(new ItemStack(Material.GOLDEN_APPLE, 2, (short) 1));
        drop.add(new ItemStack(Material.ENDER_CHEST, 3));
        drop.add(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));
        drop.add(new ItemStack(Material.DIRT, 1));
        drop.add(new ItemStack(Material.GOLDEN_APPLE, 1));
        drop.add(new ItemStack(Material.TNT, 32));
        drop.add(new ItemBuilder(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DURABILITY, 2).build());
        drop.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DURABILITY, 2).build());
        drop.add(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));
        drop.add(new ItemStack(Material.EMERALD_BLOCK, RandomUtil.getRandInt(1, 16)));
        drop.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DURABILITY, 2).build());
        drop.add(new ItemBuilder(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DURABILITY, 2).build());
        drop.add(new ItemStack(Material.ENDER_CHEST, 3));
        drop.add(new ItemBuilder(Material.DIAMOND_PICKAXE).addEnchantment(Enchantment.DIG_SPEED, 5).addEnchantment(Enchantment.DURABILITY, 3).addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3).build());
        drop.add(new ItemBuilder(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 5).addEnchantment(Enchantment.DURABILITY, 3).addEnchantment(Enchantment.FIRE_ASPECT, 2).build());
        drop.add(new ItemBuilder(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 5).addEnchantment(Enchantment.DURABILITY, 3).addEnchantment(Enchantment.KNOCKBACK, 2).build());
        drop.add(new ItemBuilder(Material.BOW).addEnchantment(Enchantment.ARROW_DAMAGE, 5).addEnchantment(Enchantment.DURABILITY, 3).addEnchantment(Enchantment.ARROW_INFINITE, 1).addEnchantment(Enchantment.ARROW_KNOCKBACK, 2).build());
        drop.add(new ItemStack(Material.ENDER_PEARL));
        drop.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle(ChatUtil.fixColor("&aKilof 5/3")).addEnchantment(Enchantment.DIG_SPEED, 5).addEnchantment(Enchantment.DURABILITY, 3).build());
        drop.add(new ItemStack(Material.HAY_BLOCK, 4));
        drop.add(new ItemStack(Material.TNT, 48));
        drop.add(new ItemStack(Material.DIRT, 1));
        drop.add(new ItemStack(Material.DIAMOND, RandomUtil.getRandInt(1, 16)));
        drop.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle(ChatUtil.fixColor("&aKilof 6/3/3")).addEnchantment(Enchantment.DIG_SPEED, 6).addEnchantment(Enchantment.DURABILITY, 3).addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3).build());
        drop.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle(ChatUtil.fixColor("&aKilof 5/3/3")).addEnchantment(Enchantment.DIG_SPEED, 5).addEnchantment(Enchantment.DURABILITY, 3).addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3).build());
    }
    static {
        CaseManager.cases = new ConcurrentHashMap<>();
        CaseManager.key = new ItemBuilder(Material.NAME_TAG).setTitle(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("key.name"))).addLores(ChatUtil.fColor(CorePlugin.getPlugin().getConfig().getStringList("key.lore"))).addEnchantment(Enchantment.DURABILITY, 10);
        CaseManager.mcase = new ItemBuilder(Material.CHEST).setTitle(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("case.name"))).addLores(ChatUtil.fColor(CorePlugin.getPlugin().getConfig().getStringList("case.lore"))).addEnchantment(Enchantment.DURABILITY, 10);
    }

    public static boolean isInCase(final Player p) {
        return CaseManager.cases.containsKey(p);
    }

    public static CaseInv getCase(final Player p) {
        return CaseManager.cases.get(p);
    }

    public static void addCase(final Player p, final CaseInv inv) {
        if (CaseManager.isInCase(p)) {
            return;
        }
        CaseManager.cases.put(p, inv);

        new BukkitRunnable() {
            @SuppressWarnings("deprecation")
			@Override
            public void run() {
                if (!isInCase(p)) {
                    this.cancel();
                    return;
                }
                if (!p.getInventory().containsAtLeast(CaseManager.key.build(), 1)) {
                    this.cancel();
                    return;
                }
                if (!p.getInventory().containsAtLeast(CaseManager.mcase.build(), 1)) {
                    this.cancel();
                    return;
                }
                if (inv.getRool() >= inv.getRoolMax()) {
                    final ItemStack win = inv.getInv().getItem(13);
                    if (win.getType() == Material.DIAMOND_PICKAXE && win.containsEnchantment(Enchantment.DIG_SPEED) && win.getEnchantmentLevel(Enchantment.DIG_SPEED) >= 6 && RandomUtil.getChance(90)) {
                        inv.setRool(inv.getRool() - 1);
                        return;

                    }

                    this.cancel();
                    p.getInventory().removeItem(key.build());
                    p.getInventory().removeItem(mcase.build());
                    Bukkit.broadcastMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("place.wylosowano-item")).replace("{NICK}", p.getName()).replace("{ILOSC}", String.valueOf(win.getAmount())).replace("{ITEM}", PolishItemNames.getPolishName(win.getType(), win.getData().getData())));
                    giveItems(p, win);
                    p.updateInventory();
                    removeCase(p);
                    firewark(p.getLocation());
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (p.getOpenInventory().getTopInventory().getName().equalsIgnoreCase(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("gui.name")))) {
                                p.closeInventory();
                            }
                        }
                    }.runTaskLater(CorePlugin.getPlugin(), 40L);
                    return;
                }
                inv.setRool(inv.getRool() + 1);
                if (!p.getOpenInventory().getTopInventory().getName().equalsIgnoreCase(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("gui.name")))) {
                    p.openInventory(inv.getInv());
                }
                p.playSound(p.getLocation(), Sound.CLICK, 10f, 10f);
                final ItemStack i = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() - 1));

                final ItemStack i1 = inv.getInv().getItem(10);
                final ItemStack i2 = inv.getInv().getItem(11);
                final ItemStack i3 = inv.getInv().getItem(12);
                final ItemStack i4 = inv.getInv().getItem(13);
                final ItemStack i5 = inv.getInv().getItem(14);
                final ItemStack i6 = inv.getInv().getItem(15);
                final ItemStack i7 = inv.getInv().getItem(16);
                final ItemStack i8 = inv.getInv().getItem(17);

                inv.getInv().setItem(9, i1);
                inv.getInv().setItem(10, i2);
                inv.getInv().setItem(11, i3);
                inv.getInv().setItem(12, i4);
                inv.getInv().setItem(13, i5);
                inv.getInv().setItem(14, i6);
                inv.getInv().setItem(15, i7);
                inv.getInv().setItem(16, i8);
                inv.getInv().setItem(17, i);
            }
        }.runTaskTimer(CorePlugin.getPlugin(), 5L, 5L);
    }


    public static void removeCase(final Player p) {
        if (!CaseManager.isInCase(p)) {
            return;
        }
        CaseManager.cases.remove(p);
    }

    public static void firewark(final Location loc) {
        final Firework fw = (Firework)loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        final FireworkMeta fwm = fw.getFireworkMeta();
        final Random r = new Random();
        final int rt = r.nextInt(4) + 1;
        FireworkEffect.Type type = FireworkEffect.Type.BALL;
        if (rt == 1) {
            type = FireworkEffect.Type.BALL;
        }
        if (rt == 2) {
            type = FireworkEffect.Type.BALL_LARGE;
        }
        if (rt == 3) {
            type = FireworkEffect.Type.BURST;
        }
        if (rt == 4) {
            type = FireworkEffect.Type.CREEPER;
        }
        if (rt == 5) {
            type = FireworkEffect.Type.STAR;
        }
        final int r1i = r.nextInt(17) + 1;
        final int r2i = r.nextInt(17) + 1;
        final Color c1 = getColor(r1i);
        final Color c2 = getColor(r2i);
        final FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
        fwm.addEffect(effect);
        final int rp = r.nextInt(2) + 1;
        fwm.setPower(rp);
        fw.setFireworkMeta(fwm);
    }

    private static Color getColor(final int i) {
        Color c = null;
        if (i == 1) {
            c = Color.AQUA;
        }
        if (i == 2) {
            c = Color.BLACK;
        }
        if (i == 3) {
            c = Color.BLUE;
        }
        if (i == 4) {
            c = Color.FUCHSIA;
        }
        if (i == 5) {
            c = Color.GRAY;
        }
        if (i == 6) {
            c = Color.GREEN;
        }
        if (i == 7) {
            c = Color.LIME;
        }
        if (i == 8) {
            c = Color.MAROON;
        }
        if (i == 9) {
            c = Color.NAVY;
        }
        if (i == 10) {
            c = Color.OLIVE;
        }
        if (i == 11) {
            c = Color.ORANGE;
        }
        if (i == 12) {
            c = Color.PURPLE;
        }
        if (i == 13) {
            c = Color.RED;
        }
        if (i == 14) {
            c = Color.SILVER;
        }
        if (i == 15) {
            c = Color.TEAL;
        }
        if (i == 16) {
            c = Color.WHITE;
        }
        if (i == 17) {
            c = Color.YELLOW;
        }
        return c;
    }

    public static ConcurrentHashMap<Player, CaseInv> getCases() {
        return CaseManager.cases;
    }
    public static void giveItems(final Player p, final ItemStack... items) {
        final Inventory i = (Inventory) p.getInventory();
        final HashMap<Integer, ItemStack> notStored = (HashMap<Integer, ItemStack>) i.addItem(items);
        for (final Map.Entry<Integer, ItemStack> e : notStored.entrySet()) {
            p.getWorld().dropItemNaturally(p.getLocation(), (ItemStack) e.getValue());
        }
    }
}
