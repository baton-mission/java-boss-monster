package bossmonster.domain;

import java.util.Arrays;

public enum AttackType {
	PHYSICAL("1", 10, 10, "물리 공격"),
	MAGIC("2", 20, 30, "마법 공격");

	private final String type;
	private final int damage;
	private final int effect;
	private final String attackName;

	AttackType(String type, int damage, int effect, String attackName) {
		this.type = type;
		this.damage = damage;
		this.effect = effect;
		this.attackName = attackName;
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

	public int getEffect() {
		return effect;
	}

	public String getAttackName() {
		return attackName;
	}
}
