package me.piechuuu.core.data;

import me.piechuuu.core.MagiCaseChatUtil.RandomUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CaseInv
{
    private Player player;
    private int rool;
    private int roolMax;
    private Inventory inv;

    public CaseInv(Player player, Inventory inv) {
        this.player = player;
        this.rool = 0;
        this.roolMax = RandomUtil.getRandInt(18, 27);
        this.inv = inv;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRool() {
        return rool;
    }

    public void setRool(int rool) {
        this.rool = rool;
    }

    public int getRoolMax() {
        return roolMax;
    }

    public void setRoolMax(int roolMax) {
        this.roolMax = roolMax;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}
