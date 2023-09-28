package bossmonster.domain;

public final class ExceptionMessage {

    public static final String BOSS_HP_RANGE_EXCEPTION_MESSAGE = "보스 몬스터의 HP는 100이상 300이하가 되어야 합니다.";
    public static final String INITIAL_HP_MP_SUM_EXCEPTION_MESSAGE = "초기 HP와 MP 합은 200이어야 합니다.";
    public static final String PLAYER_HP_EXCEPTION_MESSAGE = "초기 플레이어 HP는 0보다 커야 합니다.";
    public static final String PLAYER_MP_EXCEPTION_MESSAGE = "초기 플레이어 MP는 0보다 커야 합니다.";
    public static final String PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE = "플레이어 이름은 5자 이하만 가능합니다.";
    public static final String ATTACK_TYPE_EXCEPTION_MESSAGE = "존재하지 않는 공격 타입입니다.";
    public static final String SKILL_MP_EXCEPTION_MESSAGE = "스킬 사용에 MP가 부족합니다.";
    public static final String TURN_COUNT_EXCEPTION_MESSAGE = "시도 횟수는 0밑으로 내려갈 수 없습니다.";


    private ExceptionMessage() {
    }
}
