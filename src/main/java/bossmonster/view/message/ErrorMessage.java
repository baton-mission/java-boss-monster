package bossmonster.view.message;

public class ErrorMessage {
    public static final String INVALID_BOSS_MONSTER_HP_INPUT_ERROR_MESSAGE = "[ERROR] 보스 몬스터의 HP는 1 이상, 300 이하의 정수 값만 설정 가능 합니다.";
    public static final String INVALID_PLAYER_NAME_INPUT_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 1 이상, 5 이하의 문자열 값만 설정 가능 합니다.";
    public static final String INVALID_PLAYER_HP_AND_MP_INPUT_ERROR_MESSAGE = "[ERROR] 플레이어의 HP와 MP는 두 합이 200이면서 각각 1 ~ 200, 0 ~ 199 사이의 정수를 ,를 구분으로 입력해야합니다. (ex 100,100)";
    public static final String INVALID_PLAYER_ATTACK_OPTION_INPUT_ERROR_MESSAGE = "[ERROR] 플레이어의 공격 옵션은 주어진 정수 옵션 값만 입력 가능 합니다.";
    public static final String PLAYER_MP_NOT_ENOUGH_ERROR_MESSAGE = "[ERROR] 플레이어의 MP가 부족하여 해당 공격을 수행할 수 없습니다.";
}
