package net.arehard.core.cmds;

import com.connorlinfoot.titleapi.TitleAPI;
import net.arehard.core.ChatUtil.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommands implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if(command.getName().equalsIgnoreCase("gm")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatUtil.fixColor("&4Nie dla konsoli!"));
                return false;
            }
            if(!(commandSender.hasPermission("gamemode.pvp.core"))) {
                TitleAPI.sendTitle(p,20,50,20,ChatUtil.fixColor("&4Blad:"),ChatUtil.fixColor("&8>> &cNie masz dostepu do &7(gamemode.pvp.core)"));
                return false;
            }
            if(strings.length ==1) {
                if(strings[0].equals("0") || strings[0].equalsIgnoreCase("survival")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cSURVIVAL"));
                    return true;
                }
                if(strings[0].equals("1") || strings[0].equalsIgnoreCase("creative")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cCREATIVE"));
                    return true;
                }
                if(strings[0].equals("2") || strings[0].equalsIgnoreCase("adventure")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cADVENTURE"));
                    return true;
                }
                if(strings[0].equals("3") || strings[0].equalsIgnoreCase("spectator")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cSPECTATOR"));
                    return true;
                }
            }
            if(strings.length ==2) {
                Player cel = Bukkit.getPlayerExact(strings[0]);
                if(cel!=null) {
                    if(strings[0].equals("0") || strings[0].equalsIgnoreCase("survival")) {
                        cel.setGameMode(GameMode.SURVIVAL);
                        cel.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cSURVIVAL"));
                        commandSender.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cSURVIVAL"));
                        return true;
                    }
                    if(strings[0].equals("1") || strings[0].equalsIgnoreCase("creative")) {
                        cel.setGameMode(GameMode.CREATIVE);
                        cel.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cCREATIVE"));
                        commandSender.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cCREATIVE"));
                        return true;
                    }
                    if(strings[0].equals("2") || strings[0].equalsIgnoreCase("adventure")) {
                        cel.setGameMode(GameMode.ADVENTURE);
                        cel.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cADVENTURE"));
                        commandSender.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cADVENTURE"));
                        return true;
                    }
                    if(strings[0].equals("3") || strings[0].equalsIgnoreCase("spectator")) {
                        cel.setGameMode(GameMode.SPECTATOR);
                        cel.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cSPECTATOR"));
                        commandSender.sendMessage(ChatUtil.fixColor("&8>> &7Tryb gry zostal zmieniony na &cSPECTATOR"));
                        return true;
                    }
                } else {
                    commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cGracz jest offline!"));
                    return false;
                }
            } else {
                commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: /gm <0/1/2/3> <nick>"));
                return false;
            }
        }
        return false;
    }

}

