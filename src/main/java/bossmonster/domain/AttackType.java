package bossmonster.domain;

public enum AttackType {
	PHYSICAL(10, 10, "물리 공격"),
	MAGIC(20, 30, "마법 공격");

	public static final int PHYSICAL_TYPE = 1;
	public static final int MAGIC_TYPE = 2;

	private final int damage;
	private final int manaValue;
	private final String attackName;

	AttackType(int damage, int manaValue, String attackName) {
		this.damage = damage;
		this.manaValue = manaValue;
		this.attackName = attackName;
	}

	public static AttackType valueOfType(int type) {
		if (type < PHYSICAL_TYPE || type > MAGIC_TYPE) {
			throw new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요.");
		}
		return AttackType.values()[type - 1];
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
