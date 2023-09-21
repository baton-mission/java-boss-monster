package bossmonster.domain;

public class GameService {

	public int attackBoss(Boss boss, Player player) {
		int attackDamage = player.attackBoss();
		boss.attacked(attackDamage);
		return attackDamage;
	}

	public int attackPlayer(Boss boss, Player player) {
		int attackDamage = boss.attackPlayer();
		player.attacked(attackDamage);
		return attackDamage;
	}
}
