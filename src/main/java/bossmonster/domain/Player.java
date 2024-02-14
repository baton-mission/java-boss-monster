package bossmonster.domain;

import static bossmonster.constant.PlayerConstant.*;

public class Player {
	String name;
	int maxHp;
	int maxMp;
	int nowHp;
	int nowMp;

	public Player(String name, int maxHp, int maxMp) {
		this.name = name;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.nowHp = this.maxHp;
		this.nowMp = this.maxMp;
		isValid();
	}

	private void isValid() {
		if (name.length() > LENGTH_OF_NAME.getConstant())
			throw new IllegalArgumentException();
		if (maxHp + maxMp != SUM_OF_HP_MP.getConstant())
			throw new IllegalArgumentException();
	}
}
