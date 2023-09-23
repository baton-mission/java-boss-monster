package bossmonster.domain;

import static bossmonster.domain.AttackType.*;

public class Health {

	private static final int HP_ZERO = 0;
	private static final int MIN_BOSS_HP = 100;
	private static final int MAX_BOSS_HP = 300;
	private static final int SUM_HP_MP = 200;

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

	public boolean validateBossHpRange() {
		return hp < MIN_BOSS_HP || hp > MAX_BOSS_HP;
	}

	public boolean validatePlayerHpAndMp() {
		return (hp + mp) != SUM_HP_MP;
	}

	public boolean isHpZero() {
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

	public void spendHp(AttackType attackType) {
		hp -= attackType.getDamage();
	}

	public void calculateMp(AttackType attackType) {
		if (attackType.equals(PHYSICAL)) {
			mp += attackType.getEffect();
		}
		if (attackType.equals(MAGIC)) {
			mp -= attackType.getEffect();
		}
	}

	public boolean checkPlayerMp(AttackType type) {
		return mp < type.getEffect();
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
