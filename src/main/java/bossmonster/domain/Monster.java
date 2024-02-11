package bossmonster.domain;

public class Monster {
	int maxHp;
	int nowHp;

	public Monster(int maxHp) {
		this.maxHp = maxHp;
		this.nowHp = this.maxHp;
		isValid();
	}

	private void isValid() {
		if(maxHp < 100 || maxHp > 300)
			throw new IllegalArgumentException();
	}
}
