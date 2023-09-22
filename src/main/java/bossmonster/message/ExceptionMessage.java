package bossmonster.message;

import static bossmonster.domain.GameOption.*;

public class ExceptionMessage {
	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String IO_EXCEPTION = "입력 과정에서 에러가 발생하였습니다.";
	public static final String NUMBER_FORMAT = "숫자 형식을 입력해야합니다.";
	public static final String BOSS_HP_RANGE = "보스 몬스터의 HP 는 " +
			BOSS_HP_MIN_INCLUSIVE + "이상 " +
			BOSS_HP_MAX_INCLUSIVE + "이하만 허용됩니다.";
	public static final String PLAYER_NAME_LENGTH = "플레이어 이름은 최대 " + PLAYER_NAME_MAX_INCLUSIVE + "자 입니다.";
	public static final String PLAYER_STATS_SUM_VALUE = "플레이어 HP, MP 합은 " + PLAYER_SUM_VALUE + "이여야합니다.";
	public static final String PLAYER_STATS_NEGATIVE = "플레이어 HP, MP 는 음수일 수 없습니다.";
	public static final String PLAYER_STATS_SIZE = "플레이어의 HP 와 MP 정보를 `,` 로 구분된 값으로 입력해야합니다.";
	public static final String ATTACK_TYPE_NO_MATCH = "공격하셔야 합니다. 1 또는 2를 입력해주세요.";
	public static String BLANK = "빈 값을 입력하였습니다.";

}
