package bossmonster.view;

public class GuideText {
    public static final String BOSS_HP_INPUT = "보스 몬스터의 체력을 입력해주세요.";
    public static final String PLAYER_NAME_INPUT = "\n플레이어의 이름을 입력해주세요";
    public static final String PLAYER_HP_MP_INPUT = "\n플레이어의 HP와 MP를 입력해주세요.(,로 구분)";
    public static final String GAME_START = "\n보스 레이드를 시작합니다!";
    public static final String KILL_BOSS = "\n%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다!";
    public static final String ATTACK_STRATEGY = "어떤 공격을 하시겠습니까?\n1. 물리 공격\n2. 마법 공격";
    public static final String KILL_PLAYER = "%s의 HP가 0이 되었습니다.\n보스 레이드에 실패했습니다.";
    public static final String MAGIK_ATTACK = "\n마법공격을 했습니다. (입힌 데미지: %d)";
    public static final String NORMAL_ATTACK = "\n물리공격을 했습니다. (입힌 데미지: %d)";
    public static final String BOSS_ATTACK = "보스가 공격을 했습니다. (입힌 데미지: %d)";
    public static final String NEW_LINE_DOUBLE_LINE = "\n============================";
    public static final String DOUBLE_LINE_NEW_LINE = "============================\n";
    public static final String SINGLE_LINE = "____________________________";
    public static final String SINGLE_LINE_NEW_LINE = String.format("%s\n", SINGLE_LINE);

    public static final String BOSS_INIT_ICON = "____________________________\n" +
            "       ^-^\n" +
            "     / 0 0 \\\n" +
            "    (   \"   )\n" +
            "     \\  -  /\n" +
            "      - ^ -\n" +
            "____________________________\n";
    public static final String BOSS_WIN_ICON = "____________________________\n" +
            "       ^-^\n" +
            "     / ^ ^ \\\n" +
            "    (   \"   )\n" +
            "     \\  3  /\n" +
            "      - ^ -\n" +
            "____________________________\n" +
            "\n";
    public static final String BOSS_HIT_ICON = "____________________________\n" +
            "       ^-^\n" +
            "     / x x \\\n" +
            "    (   \"\\  )\n" +
            "     \\  ^  /\n" +
            "      - ^ -\n" +
            "____________________________\n";
    public static final String FORCE_NORMAL_ATTACK = "마나가 부족해 일반 공격을 합니다.";
}
