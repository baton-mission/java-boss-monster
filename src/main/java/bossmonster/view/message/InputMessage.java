package bossmonster.view.message;

public class InputMessage {
    public static final String INPUT_BOSS_MONSTER_HP_MESSAGE = "보스 몬스터의 HP를 입력해주세요. [100 이상, 300 이하 정수 값만 입력 가능]";
    public static final String INPUT_PLAYER_NAME_MESSAGE = "플레이어의 이름을 입력해주세요. [1 이상, 5 이하 문자열 값만 입력 가능]";
    public static final String INPUT_PLAYER_HP_AND_MP_MESSAGE = "플레이어의 HP와 MP를 입력해주세요.(,로 구분(ex. 100,100), hp는 1 이상 200 이하, mp는 0 이상 199 이하, hp와 mp의 합은 200이어야 합니다.)";
    public static final String INPUT_PLAYER_ATTACK_OPTION =
            "어떤 공격을 하시겠습니까?\n" +
            "1. 물리 공격 (데미지 10, MP 0 소모, HP 10 회복)\n" +
            "2. 마법 공격 (데미지 20, MP 30 소모)";
}
