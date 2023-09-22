package bossmonster.domain;

public class Hp {

	private final int hp;

	public Hp(int hp) {
		this.hp = hp;
	}

	public boolean validateBossHpRange() {
		return hp < 100 || hp > 300;
	}
}
