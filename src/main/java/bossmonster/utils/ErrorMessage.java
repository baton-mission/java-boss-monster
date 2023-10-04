package bossmonster.utils;

public class ErrorMessage {

    public static final String ERROR_NUMBER_FORMAT = "[ERROR] 정수만 입력 가능합니다.";
    public static final String ERROR_BOSS_MONSTER_HP_OUT_OF_RANGE = "[ERROR] 보스 몬스터의 HP는 %d 이상 %d 이하여야 합니다.";
    public static final String ERROR_PLAYER_NAME_LENGTH_OVER = "[ERROR] 플레이어의 이름은 %d자 이하여야 합니다.";
    public static final String ERROR_INPUT_FORMAT = "[ERROR] 입력 형식이 일치하지 않습니다.";
    public static final String ERROR_SUM_OF_INITIAL_HP_AND_MP = "[ERROR] 플레이어의 초기 HP와 MP의 합은 %d이어야 합니다.";
    public static final String ERROR_NOT_ENOUGH_MP = "[ERROR] MP가 부족합니다.";
    public static final String ERROR_NOT_FOUND_ATTACK_FOR_NUMBER = "[ERROR] 입력한 번호에 해당하는 공격이 존재하지 않습니다.";

    private ErrorMessage() {
    }
}
