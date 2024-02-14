package bossmonster.domain;

import static bossmonster.constant.MonsterConstant.*;

public class Monster {
	int maxHp;
	int nowHp;

	public Monster(int maxHp) {
		this.maxHp = maxHp;
		this.nowHp = this.maxHp;
		isValid();
	}

	private void isValid() {
		if (maxHp < MONSTER_MIN_HP.getMonsterConstant() || maxHp > MONSTER_MAX_HP.getMonsterConstant())
			throw new IllegalArgumentException();
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getNowHp() {
		return nowHp;
	}
}
