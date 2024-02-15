package bossmonster.constant;

import java.util.Arrays;

public enum PlayerConstant {
	SUM_OF_HP_MP(200),
	MAGIC_ATTACK(2),
	MAGIC_DAMAGE(20),
	COUNT_OF_HP_MP(2),
	LENGTH_OF_NAME(5),
	PHYSICAL_ATTACK(1),
	PHYSICAL_DAMAGE(10),
	MP_COST_AFTER_PHYSICAL(10),
	MP_COST_AFTER_MAGIC(-30);

	private final int constant;

	PlayerConstant(int constant) {
		this.constant = constant;
	}

	public static PlayerConstant of(final int constant) {
		return Arrays.stream(values())
			.filter(val -> constant == val.constant)
			.findFirst()
			.orElse(null);
	}

	public int getConstant() {
		return constant;
	}
}
