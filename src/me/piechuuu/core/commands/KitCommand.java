package me.piechuuu.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class KitCommand implements CommandExecutor, Listener {

    private Inventory kity = Bukkit.createInventory(null, 9, "§aZestawy");

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {
        if(cmd.getName().equalsIgnoreCase("kit")) {

        }
        return false;
    }


}
