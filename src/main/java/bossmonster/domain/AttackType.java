package bossmonster.domain;

public enum AttackType {
	PHYSICAL(10, 10, "물리 공격"),
	MAGIC(20, 30, "마법 공격");

	public static final int PHYSICAL_INDEX = 1;
	public static final int MAGIC_INDEX = 2;

	private final int damage;
	private final int manaValue;
	private final String attackName;

	AttackType(int damage, int manaValue, String attackName) {
		this.damage = damage;
		this.manaValue = manaValue;
		this.attackName = attackName;
	}

	public static AttackType toAttackType(int type) {
		validateTypeRange(type);
		return AttackType.values()[type - 1];
	}

	private static void validateTypeRange(int type) {
		if (type < PHYSICAL_INDEX || type > MAGIC_INDEX) {
			throw new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요.");
		}
	}

	public int getDamage() {
		return damage;
	}

	public int getManaValue() {
		return manaValue;
	}

	public String getAttackName() {
		return attackName;
	}
}
