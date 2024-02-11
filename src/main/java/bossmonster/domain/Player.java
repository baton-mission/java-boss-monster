package bossmonster.domain;

class Player {
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
		if (name.length() > 5)
			throw new IllegalArgumentException();
		if (maxHp + maxMp != 200)
			throw new IllegalArgumentException();
	}
}
