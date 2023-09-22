package bossmonster.domain;

import bossmonster.domain.boss.Boss;
import bossmonster.domain.boss.BossStatus;
import bossmonster.domain.player.Player;

public class GameService {

	public int attackBoss(Boss boss, Player player) {
		int attackDamage = player.attackBoss();
		boss.attacked(attackDamage);
		return attackDamage;
	}

	public int attackPlayer(Boss boss, Player player) {
		if (!boss.isAlive()) return 0;
		int attackDamage = boss.attackPlayer();
		player.attacked(attackDamage);
		if (!player.isAlive()) {
			boss.handleBossStatus(false, true);
		}
		return attackDamage;
	}
}
