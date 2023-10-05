package bossmonster.dto;

import bossmonster.domain.Player;

public class PlayerHpMpParam {
    private int hp;
    private int mp;

    public PlayerHpMpParam(int hp, int mp) {
        this.hp = hp;
        this.mp = mp;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public static PlayerHpMpParam from(Player player) {
        return new PlayerHpMpParam(player.getCurrentHp(), player.getCurrentMp());
    }
}
