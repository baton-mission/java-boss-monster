package bossmonster.service;

import bossmonster.domain.AttackType;
import bossmonster.domain.Boss;
import bossmonster.domain.GameStatus;
import bossmonster.domain.Player;

public class GameService {

    private final GameStatus gameStatus;

    public GameService(GameStatus status) {
        this.gameStatus = status;
    }

    public void attackToBoss(Boss boss, Player player, AttackType type) {
        boss.getDamage(type.getDamage());
        gameStatus.updateAttackType(type);
        player.updateMana(type);
    }

    public void attackToPlayer(int bossDamage, Player player) {
        player.getDamage(bossDamage);
        gameStatus.updateBossDamage(bossDamage);
    }
}
