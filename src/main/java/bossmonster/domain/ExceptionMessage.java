package bossmonster.domain;

public final class ExceptionMessage {

    public static final String BOSS_HP_RANGE_EXCEPTION_MESSAGE = "보스 몬스터의 HP는 100이상 300이하가 되어야 합니다.";
    public static final String INITIAL_HP_MP_SUM_EXCEPTION_MESSAGE = "초기 HP와 MP 합은 200이어야 합니다.";
    public static final String PLAYER_HP_EXCEPTION_MESSAGE = "초기 플레이어 HP는 0보다 커야 합니다.";
    public static final String PLAYER_MP_EXCEPTION_MESSAGE = "초기 플레이어 MP는 0보다 커야 합니다.";
    public static final String PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE = "플레이어 이름은 5자 이하만 가능합니다.";


    private ExceptionMessage() {
    }
}
