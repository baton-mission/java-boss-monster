package bossmonster.domain;

public class GameService {

	public int attackBoss(Boss boss, Player player) {
		int attackDamage = player.getAttackDamage();
		boss.attacked(attackDamage);
		player.handleCost();
		return attackDamage;
	}

	public int attackPlayer(Boss boss, Player player) {
		int attackDamage = boss.getAttackDamage();
		player.attacked(attackDamage);
		return attackDamage;
	}
}
