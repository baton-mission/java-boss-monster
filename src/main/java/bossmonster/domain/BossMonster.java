package bossmonster.domain;

public class BossMonster {

	private final Health health;

	public BossMonster(Health health) {
		validateHpRange(health);
		this.health = health;
	}

	private void validateHpRange(Health health) {
		if (health.validateBossHpRange()) {
			throw new IllegalArgumentException("[ERROR] 보스 몬스터의 초기 HP는 100이상 300이하 입니다.");
		}
	}

	public boolean bossHpZero() {
		return health.isDead();
	}

	public void attackedByPlayer(AttackType attackType) {
		health.spendHp(attackType);
	}

	public int remainedBossHp() {
		return health.getHp();
	}

	public Health getHealth() {
		return health;
	}

	public int getInitHp() {
		return health.getInitHp();
	}
}
