package bossmonster;

public enum Message {
	READ_BOSS_HP("보스 몬스터의 HP를 입력해주세요."),
	READ_PLAYER_NAME("플레이어의 이름을 입력해주세요."),
	READ_PLAYER_HP_MP("플레이어의 HP와 MP를 입력해주세요.(,로 구분)"),
	START_RADE("보스 레이드를 시작합니다!"),
	HP_STATUS_FORMAT("%s HP [%d/%d]\n"),
	DIV("____________________________\n");
	private final String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
