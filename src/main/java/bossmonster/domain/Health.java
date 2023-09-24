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
		validateHpRange(hp);
		return hp <= HP_ZERO;
	}

	private void validateHpRange(int hp) {
		if (hp < 0) {
			setHpZero();
		}
	}

	private void setHpZero() {
		hp = HP_ZERO;
	}

	public void spendHp(int damage) {
		hp -= damage;
	}

	public void calculateMp(AttackType attackType) {
		if (attackType.equals(PHYSICAL)) {
			setMp(attackType);
		}
		if (attackType.equals(MAGIC)) {
			mp -= attackType.getManaValue();
		}
	}

	private void setMp(AttackType attackType) {
		if (checkMaximumMp(attackType)) {
			mp = initMp;
		}
		if (!checkMaximumMp(attackType)) {
			mp += attackType.getManaValue();
		}
	}

	private boolean checkMaximumMp(AttackType attackType) {
		return mp + attackType.getManaValue() > initMp;
	}

	public boolean isRemainPlayerMp(AttackType type) {
		return mp >= type.getManaValue();
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
