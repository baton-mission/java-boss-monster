package bossmonster.domain;

public class Player {

	private final String name;

	public Player(String name) {
		validatePlayerLength(name);
		this.name = name;
	}

	private void validatePlayerLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 플레이어의 이름은 5자 이하만 가능합니다.");
		}
	}
}
