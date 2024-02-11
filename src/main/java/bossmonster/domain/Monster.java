package bossmonster.domain;

public class Monster {
	int maxHp;
	int nowHp;

	public Monster(int maxHp) {
		this.maxHp = maxHp;
		this.nowHp = this.maxHp;
	}
}
