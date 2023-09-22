package bossmonster.domain;

public class Player {

	private final String name;
	private final Health health;

	public Player(String name, Health health) {
		validatePlayerLength(name);
		validateHPAndMp(health);
		this.name = name;
		this.health = health;
	}

	private void validatePlayerLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 플레이어의 이름은 5자 이하만 가능합니다.");
		}
	}

	private void validateHPAndMp(Health health) {
		if (health.validatePlayerHpAndMp()) {
			throw new IllegalArgumentException("[ERROR] 플레이어의 초기 HP와 MP의 합은 200이어야 합니다.");
		}
	}

	public boolean playerHpZero() {
		return health.getHp() != 0;
	}

	public String getName() {
		return name;
	}
}
