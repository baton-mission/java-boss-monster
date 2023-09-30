package bossmonster.service;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class Battle {

    public boolean isVictory(BossMonster bossMonster) {
        if (bossMonster.getHp() == 0) {
            return true;
        }

        return false;
    }

    public boolean isDefeat(Player player) {
        if (player.getHp() == 0) {
            return true;
        }
        return false;
    }
}
