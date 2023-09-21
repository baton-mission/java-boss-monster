package bossmonster;

import bossmonster.domain.GameOption;

public class ExceptionMessage {
	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String IO_EXCEPTION = "입력 과정에서 에러가 발생하였습니다.";
	public static final String NUMBER_FORMAT = "숫자 형식을 입력해야합니다.";
	public static final String BOSS_HP_RANGE = "보스 몬스터의 HP 는 " +
			GameOption.BOSS_HP_MIN_INCLUSIVE + "이상 " +
			GameOption.BOSS_HP_MAX_INCLUSIVE + "이하만 허용됩니다.";
	public static String BLANK = "빈 값을 입력하였습니다.";

}
