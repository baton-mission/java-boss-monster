package bossmonster.constant;

public enum MonsterConstant {
	MONSTER_MAX_HP(300),
	MONSTER_MIN_HP(100),
	MONSTER_MAX_DAMAGE(20),
	MONSTER_MIN_DAMAGE(0);

	private final int monsterConstant;

	MonsterConstant(int monsterConstant) {
		this.monsterConstant = monsterConstant;
	}

	public int getMonsterConstant() {
		return monsterConstant;
	}
}
