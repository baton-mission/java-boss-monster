package bossmonster.constant;

public enum AttackConstant {
	PHYSICAL(1, "물리 공격"),
	MAGIC(2, "마법 공격");

	private final int attackInt;
	private final String attackString;

	AttackConstant(int attackInt, String attackString) {
		this.attackInt = attackInt;
		this.attackString = attackString;
	}

	public int getAttackInt() {
		return attackInt;
	}

	public String getAttackString() {
		return attackString;
	}
}
