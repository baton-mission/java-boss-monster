package bossmonster.domain;

public class GameService {

	public void attackBoss(Boss boss, Player player) {
		boss.attacked(player.getAttackDamage());
		player.handleCost();
	}
}
