package me.piechuuu.core.listener;

import com.connorlinfoot.titleapi.TitleAPI;
import me.piechuuu.core.CorePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InvCllickEvent implements Listener {

    CorePlugin plugin = CorePlugin.hook();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null){
            return;
        }
        if(!e.getCurrentItem().hasItemMeta()){
            return;
        }

        if(e.getInventory().getName().contains("sklep")) {
            e.setCancelled(true);
            Integer coinamount = plugin.coinData.get(p.getUniqueId());

            if(coinamount == null){
                TitleAPI.sendTitle(p, 20, 50, 20, "§4§lSKLEP", "§8» §cNie posiadasz tyle coinsow");
                plugin.coinData.put(p.getUniqueId(), 5);
                return;
            }
            Integer price = Integer.parseInt(e.getCurrentItem().getItemMeta().getLore().get(1));

            if(coinamount < price){
                p.sendMessage("§4Blad: §cNie masz wystarczajacych monet Posiadasz §7" + coinamount + "§ccena wynosi" + price + "§7:)" );
                plugin.coinData.put(p.getUniqueId(), 5 + plugin.coinData.get(p.getUniqueId()));
                return;
            }
            plugin.coinData.put(p.getUniqueId(), coinamount-price);
            p.sendMessage("§cPomyslnie zakupiles %item% za %price% ".replaceAll("%price%", e.getCurrentItem().getType().name()).replaceAll("%price%", e.getCurrentItem().getItemMeta().getLore().get(1)));
            p.getInventory().addItem(new ItemStack(e.getCurrentItem().getType()));
        }
    }
}
