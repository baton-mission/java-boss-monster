package bossmonster.domain;

class Player {
	String name;
	int hp;
	int mp;

	public Player(String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		isValid();
	}

	private void isValid() {
		if (name.length() > 5)
			throw new IllegalArgumentException();
		if (hp + mp != 200)
			throw new IllegalArgumentException();
	}
}
