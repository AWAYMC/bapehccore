package me.piechuuu.core.listener;

import me.piechuuu.core.CorePlugin;
import me.piechuuu.core.MagiCaseChatUtil.ChatUtil;
import me.piechuuu.core.MagiCaseChatUtil.ItemBuilder;
import me.piechuuu.core.MagiCaseChatUtil.RandomUtil;
import me.piechuuu.core.data.CaseInv;
import me.piechuuu.core.managers.CaseManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CasePlaceListener implements Listener
{
    @SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final Block b = e.getBlock();
        if (!(b.getType() == Material.CHEST && p.getItemInHand().getItemMeta().getDisplayName().equals(CaseManager.mcase.build().getItemMeta().getDisplayName()))) {
        	return;
        }
        if (b.getType() == Material.CHEST && p.getItemInHand().getItemMeta().getDisplayName().equals(CaseManager.mcase.build().getItemMeta().getDisplayName())) {
            e.setCancelled(true);
            if (CaseManager.isInCase(p)) {
                p.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("error.already-opening")));
                return;
            }
            if (!p.getInventory().containsAtLeast(CaseManager.key.build(), 1)) {
                p.sendMessage(ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("error.klucz")));
                return;
            }
            final Inventory inv = Bukkit.createInventory(p, 27, ChatUtil.fixColor(CorePlugin.getPlugin().getConfig().getString("gui.name")));
            final ItemBuilder backgroup = new ItemBuilder(Material.getMaterial(160), 1, (short)14).setTitle(ChatUtil.fixColor(""));
            final ItemBuilder win = new ItemBuilder(Material.getMaterial(160), 1, (short)1).setTitle(ChatUtil.fixColor(""));

            for (int i = 0; i <= 3; i++) {
                inv.setItem(i, backgroup.build());
            }
            inv.setItem(4, win.build());

            for (int i = 5; i <= 8; i++) {
                inv.setItem(i, backgroup.build());
            }

            for (int i = 18; i <= 21; i++) {
                inv.setItem(i, backgroup.build());
            }

            inv.setItem(22, win.build());


            for (int i = 23; i <= 26; i++) {
                inv.setItem(i, backgroup.build());
            }

            final ItemStack i1 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));
            final ItemStack i2 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));
            final ItemStack i3 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));
            final ItemStack i4 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));
            final ItemStack i5 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));
            final ItemStack i6 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));
            final ItemStack i7 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));
            final ItemStack i8 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));
            final ItemStack i9 = CaseManager.drop.get(RandomUtil.getRandInt(0, CaseManager.drop.size() -1));

            inv.setItem(9, i1);
            inv.setItem(10, i2);
            inv.setItem(11, i3);
            inv.setItem(12, i4);
            inv.setItem(13, i5);
            inv.setItem(14, i6);
            inv.setItem(15, i7);
            inv.setItem(16, i8);
            inv.setItem(17, i9);
            p.openInventory(inv);

            final CaseInv caseInv = new CaseInv(p, inv);
           CaseManager.addCase(p, caseInv);
        }
    }
}
