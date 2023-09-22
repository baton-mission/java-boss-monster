package bossmonster.domain;

public class Health {

	private final int hp;
	private final int mp;

	public Health(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
	}

	public boolean validateBossHpRange() {
		return hp < 100 || hp > 300;
	}

	public boolean validatePlayerHpAndMp() {
		return (hp + mp) != 200;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}
}
