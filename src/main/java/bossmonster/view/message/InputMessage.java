package bossmonster.view.message;

public enum InputMessage {
	MONSTER_HP("보스 몬스터의 HP를 입력해주세요."),
	PLAYER_NAME("플레이어의 이름을 입력해주세요."),
	PLAYER_HP_MP("플레이어의 HP와 MP를 입력해주세요.(,로 구분)"),
	WHETHER_PHYSICAL_OR_MAGIC("어떤 공격을 하시겠습니까?\n1. 물리 공격\n2. 마법 공격");

	private final String message;

	InputMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
