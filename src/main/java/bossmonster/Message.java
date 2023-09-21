package bossmonster;

public enum Message {
	READ_BOSS_HP("보스 몬스터의 HP를 입력해주세요."),
	READ_PLAYER_NAME("플레이어의 이름을 입력해주세요."),
	READ_PLAYER_HP_MP("플레이어의 HP와 MP를 입력해주세요.(,로 구분)"),
	START_RADE("보스 레이드를 시작합니다!"),
	HP_STATUS_FORMAT("%s HP [%d/%d]\n"),
	HP_AND_MP_STATUS_FORMAT("%s HP [%d/%d] MP [%d/%d]\n"),
	DIV("____________________________"),
	DOUBLE_DIV("============================"),
	READ_ATTACK_TYPE("어떤 공격을 하시겠습니까?\n" +
			"1. 물리 공격\n" +
			"2. 마법 공격");
	private final String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
