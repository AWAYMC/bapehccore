package me.piechuuu.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Ta komende moze wywolac tylko gracz");
            return false;
        }
        if(!commandSender.hasPermission("bapehc.core.gm")){
            commandSender.sendMessage("§8» §4Blad: §cNie masz dostepu do §7(bapehc.core.gm)");
            return false;
        }
        if(strings.length == 1){
            if(strings[0].equals(0) || strings[0].equalsIgnoreCase("s")){
                Player p = (Player) commandSender;
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage("§8» §cTwoj tryb gry zostal zmieniony na §4Survival");
                return true;
            }
            if(strings[0].equals(1) || strings[0].equalsIgnoreCase("c")){
                Player p = (Player) commandSender;
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage("§8» §cTwoj tryb gry zostal zmieniony na §4Creative");
                return true;
            }
            if(strings[0].equals(3) || strings[0].equalsIgnoreCase("sp")){
                Player p = (Player) commandSender;
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage("§8» §cTwoj tryb gry zostal zmieniony na §4Sectator");
                return true;
            }
        }
        if(strings.length == 2){
            Player cel = Bukkit.getPlayerExact(strings[1]);
            if(cel!=null) {
                if (strings[0].equals(0) || strings[0].equalsIgnoreCase("s")) {
                    cel.setGameMode(GameMode.SURVIVAL);
                    cel.sendMessage("§8» §cTwoj tryb gry zostal zmieniony na §4Survival");
                    commandSender.sendMessage("§cZmieniles tryb gry §7" + cel.getName() + " §cna §4Survival");
                    return true;
                }
                if (strings[0].equals(1) || strings[0].equalsIgnoreCase("c")) {
                    cel.setGameMode(GameMode.CREATIVE);
                    cel.sendMessage("§8» §cTwoj tryb gry zostal zmieniony na §4Creative");
                    commandSender.sendMessage("§cZmieniles tryb gry §7" + cel.getName() + " §cna §4Creative");
                    return true;
                }
                if (strings[0].equals(3) || strings[0].equalsIgnoreCase("sp")) {
                    cel.setGameMode(GameMode.SPECTATOR);
                    cel.sendMessage("§8» §cTwoj tryb gry zostal zmieniony na §4SPECTATOR");
                    commandSender.sendMessage("§cZmieniles tryb gry §7" + cel.getName() + " §cna §4SPECTATOR");
                    return true;
                }
            }else{
                commandSender.sendMessage("§8» §4Blad: §cPodany gracz jest §4Offline");
                return false;
            }
        }else{
            commandSender.sendMessage("§8» §4Blad: §cPoprawne uzycie: §7/gm <nick> <0|1|3>");
        }
        return false;
    }
}
