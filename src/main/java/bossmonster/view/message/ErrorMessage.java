package bossmonster.view.message;

public enum ErrorMessage {
	ERROR_PREFIX("[ERROR] "),
	MONSTER_HP_MORE_THAN_100_LESS_THAN_300("보스 몬스터의 HP는 100 이상 300 이하여야 합니다."),
	PLAYER_NAME_LENGTH_LESS_THAN_5_WORDS("플레이어의 이름은 5글자 이하여야 합니다."),
	SUM_OF_PLAYER_HP_AND_MP_IS_200("플레이어의 HP와 MP의 합은 200이어야 합니다."),
	COUNT_OF_PLAYER_HP_AND_MP_IS_2("플레이어의 HP와 MP를 명확히 입력해주세요."),
	PLAYER_SHOULD_ATTACK_MONSTER("공격하셔야 합니다. 1 또는 2를 입력해주세요."),
	MAGIC_ATTACK_CONSUME_MP("MP가 부족하여 마법 공격을 사용할 수 없습니다."),
	MUST_INTEGER_BUT_NOT("숫자를 입력하셔야 합니다."),
	MUST_POSITIVE_BUT_NOT("양수를 입력하셔야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return ERROR_PREFIX.message + message;
	}
}
