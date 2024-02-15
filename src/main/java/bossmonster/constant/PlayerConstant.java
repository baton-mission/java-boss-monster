package bossmonster.constant;

public enum PlayerConstant {
	SUM_OF_HP_MP(200),
	COUNT_OF_HP_MP(2),
	LENGTH_OF_NAME(5),
	PHYSICAL(1),
	MAGIC(2);

	private final int constant;

	PlayerConstant(int constant) {
		this.constant = constant;
	}

	public int getConstant() {
		return constant;
	}
}
