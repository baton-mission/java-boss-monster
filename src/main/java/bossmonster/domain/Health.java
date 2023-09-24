package bossmonster.domain;

import static bossmonster.domain.AttackType.*;

public class Health {

	private static final int HP_ZERO = 0;

	private int hp;
	private int mp;
	private int initHp;
	private int initMp;

	public Health(int hp) {
		this.hp = hp;
		initHp = hp;
	}

	public Health(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
		initHp = hp;
		initMp = mp;
	}

	public boolean isValidHpRange(int minHp, int maxHp) {
		return hp < minHp || hp > maxHp;
	}

	public boolean isValidSumHpAndMp(int sumHpAndMp) {
		return (hp + mp) != sumHpAndMp;
	}

	public boolean isDead() {
		if (hp <= HP_ZERO) {
			setHpZero();
			return true;
		}
		return false;
	}

	private void setHpZero() {
		hp = HP_ZERO;
	}

	public void spendHp(int damage) {
		hp -= damage;
	}

	public void calculateMp(AttackType attackType) {
		if (attackType.equals(PHYSICAL)) {
			checkMaximumMp(attackType);
		}
		if (attackType.equals(MAGIC)) {
			mp -= attackType.getManaValue();
		}
	}

	private void checkMaximumMp(AttackType attackType) {
		if (mp + attackType.getManaValue() > initMp) {
			mp = initMp;
		}
		if (mp + attackType.getManaValue() < initMp) {
			mp += attackType.getManaValue();
		}
	}

	public boolean isRemainPlayerMp(AttackType type) {
		return mp > type.getManaValue();
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public int getInitHp() {
		return initHp;
	}

	public int getInitMp() {
		return initMp;
	}
}
