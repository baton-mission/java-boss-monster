package bossmonster.util;

public final class Constants {

    //Numbers
    public static final int HP_MP_SUM = 200;
    public static final int MAX_HP = 300;
    public static final int MIN_HP = 100;
    public static final int ZERO = 0;

    //InputView
    public static final String BOSS_HP_INPUT = "보스 몬스터의 HP를 입력해주세요.";
    public static final String PLAYER_NAME_INPUT = "플레이어의 이름을 입력해주세요";
    public static final String PLAYER_INFO_INPUT = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";
    public static final String SPLIT_UNIT = ",";
    public static final String ATTACK_INPUT = "어떤 공격을 하시겠습니까?\n1. 물리 공격\n2. 마법 공격";

    //OutPutView
    public static final String START_MESSAGE = "보스 레이드를 시작합니다!\n";
    public static final String ATTACK_MESSAGE = "%s를 했습니다. (입힌 데미지: %s)\n";
    public static final String BOSS_ATTACK_MESSAGE = "보스가 공격 했습니다. (입힌 데미지: %s)\n";
    public static final String BOSS_DIE_MESSAGE = "%s 님이 %s번의 전투 끝에 보스 몬스터를 잡았습니다.";
    public static final String ZERO_HP_MESSAGE = "%s의 HP가 0이 되었습니다.\n";
    public static final String FAIL_MESSAGE = "보스 레이드에 실패했습니다.";

    public static final String SETTING_FORMAT =
            """
            ============================
            BOSS HP [%s/%s]
            ____________________________
               ^-^
             / 0 0 \\
            (   "   )
             \\  -  /
              - ^ -
            ____________________________
            %s HP [%s/%s] MP [%s/%s]
            ============================
                    
            """;

    public static final String RESULT_FORMAT =
            """
            ============================
            BOSS HP [%s/%s]
            ____________________________
               ^-^
             / X X \\
            (   "   )
             \\  -  /
              - ^ -
            ____________________________
            %s HP [%s/%s] MP [%s/%s]
            ============================
                    
            """;
}
