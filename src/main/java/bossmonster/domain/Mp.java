package bossmonster.domain;

import bossmonster.domain.player.PlayerVital;

public class Mp {
    private int mp;

    public Mp(int mp) {
        this.mp = mp;
    }

    public void applyPlayerAttack(PlayerAttack playerAttack) {
        int newMp = playerAttack.applyMp(mp);
        if (isOverMax(newMp)) {
            mp = PlayerVital.MAX_PLAYER_VITAL_SUM;
        }
        if (!isOverMax(newMp)) {
            mp = newMp;
        }
    }

    private static boolean isOverMax(int newMp) {
        return newMp > PlayerVital.MAX_PLAYER_VITAL_SUM;
    }

    public boolean isUnderEmpty() {
        return mp < 0;
    }

    public int getMp() {
        return mp;
    }
}
