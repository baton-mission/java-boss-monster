package bossmonster.service;

import bossmonster.domain.AttackType;
import bossmonster.domain.Boss;
import bossmonster.domain.Player;

public class GameService {

    public void attackToBoss(Boss boss, AttackType type) {
        boss.getDamage(type.getDamage());
    }

    public void attackToPlayer(Player player, int bossDamage) {
        player.getDamage(bossDamage);
    }
}
