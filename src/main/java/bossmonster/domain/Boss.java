package bossmonster.domain;

import bossmonster.ExceptionMessage;

public class Boss {
	private int hp;
	private int mp;

	public Boss(int hp) {
		validate(hp);
		this.hp = hp;
		this.mp = hp;
	}

	private void validate(int hp) {
		isInRange(hp);
	}

	private void isInRange(int hp) {
		if (hp < GameOption.BOSS_HP_MIN_INCLUSIVE ||
				hp > GameOption.BOSS_HP_MAX_INCLUSIVE) {
			throw new IllegalArgumentException(ExceptionMessage.BOSS_HP_RANGE);
		}
	}
}
