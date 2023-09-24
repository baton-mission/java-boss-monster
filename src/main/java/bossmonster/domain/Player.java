package bossmonster.domain;

public class Player {

	private static final int MAX_PLAYER_LENGTH = 5;

	private final String name;
	private final Health health;

	public Player(String name, Health health) {
		validatePlayerLength(name);
		validateHPAndMp(health);
		this.name = name;
		this.health = health;
	}

	private void validatePlayerLength(String name) {
		if (name.length() > MAX_PLAYER_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 이름의 길이가 유효하지 않습니다.");
		}
	}

	private void validateHPAndMp(Health health) {
		if (health.validatePlayerHpAndMp()) {
			throw new IllegalArgumentException("[ERROR] 플레이어의 초기 HP와 MP의 합이 올바르지 않습니다.");
		}
	}

	public boolean isRemainMP(AttackType type) {
		if (health.isRemainPlayerMp(type)) {
			return true;
		}
		throw new IllegalArgumentException("[ERROR] MP가 부족합니다.");
	}

	public void attack(AttackType type) {
		health.calculateMp(type);
	}

	public void attackedBy(int bossHitDamage) {
		health.spendHp(bossHitDamage);
	}

	public boolean isPlayerDead() {
		return health.isDead();
	}

	public String getName() {
		return name;
	}

	public Health getHealth() {
		return health;
	}

	public int getInitHp() {
		return health.getInitHp();
	}

	public int getInitMp() {
		return health.getInitMp();
	}
}
