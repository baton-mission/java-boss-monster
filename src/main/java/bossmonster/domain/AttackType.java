package bossmonster.domain;

import java.util.Arrays;

public enum AttackType {
	PHYSICAL("1", 10),
	MAGIC("2", 20);

	private final String type;
	private final int damage;

	AttackType(String type, int damage) {
		this.type = type;
		this.damage = damage;
	}

	public static AttackType valueOfType(String type) {
		return Arrays.stream(AttackType.values())
			.filter(attackType -> attackType.getType().equals(type))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 1 또는 2를 입력해주세요"));
	}

	public String getType() {
		return type;
	}

	public int getDamage() {
		return damage;
	}
}
