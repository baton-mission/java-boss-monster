package bossmonster.service;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class Battle {
    private final int PHYSICAL_ATTACK = 1;
    private final int MAGIC_ATTACK = 2;

    public void attackBossMonster(Player player, BossMonster bossMonster, int attackType) {
        if (attackType == PHYSICAL_ATTACK) {
            player.getMp();
            bossMonster.reduceHp(10);
        }

        if (attackType == MAGIC_ATTACK) {
            player.consumeMp();
            bossMonster.reduceHp(20);
        }
    }

    public void attackPlayer(Player player, BossMonster bossMonster) {
        int damage = (int) Math.random() * 20;
        player.reduceHp(damage);
    }
}
