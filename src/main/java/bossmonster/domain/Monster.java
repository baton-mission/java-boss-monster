package bossmonster.domain;

import static bossmonster.constant.MonsterConstant.*;

import java.util.Random;

public class Monster {
	private static final Random random = new Random();
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

	public int createAttack() {
		return random.nextInt(MONSTER_MAX_DAMAGE.getMonsterConstant());
	}

	public int getAttackByPlayer(int damage) {
		if(nowHp <= damage) {
			nowHp = 0;
			return nowHp;
		}

		nowHp -= damage;
		return damage;
	}
}
