package bossmonster.domain;

public class BossMonster {

	private static final int MAX_BOSS_HIT_DAMAGE = 20;
	private static final int MIN_BOSS_HP = 100;
	private static final int MAX_BOSS_HP = 300;

	private final Health health;
	private final RandomDamageGenerator randomDamageGenerator;

	public BossMonster(Health health, RandomDamageGenerator randomDamageGenerator) {
		validateHpRange(health);
		validateBossHitDamage(randomDamageGenerator);
		this.health = health;
		this.randomDamageGenerator = randomDamageGenerator;
	}

	private void validateHpRange(Health health) {
		if (health.isValidHpRange(MIN_BOSS_HP, MAX_BOSS_HP)) {
			throw new IllegalArgumentException("[ERROR] 보스 몬스터의 초기 HP의 범위가 유효하지 않습니다.");
		}
	}

	private void validateBossHitDamage(RandomDamageGenerator randomDamageGenerator) {
		if (randomDamageGenerator.generate() > MAX_BOSS_HIT_DAMAGE) {
			throw new IllegalArgumentException("[ERROR] 데미지에 오류가 발생하였습니다.");
		}
	}

	public int generateBossHitDamage() {
		return randomDamageGenerator.generate();
	}

	public boolean isBossDead() {
		return health.isDead();
	}

	public void attackedByPlayer(AttackType attackType) {
		health.spendHp(attackType.getDamage());
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
