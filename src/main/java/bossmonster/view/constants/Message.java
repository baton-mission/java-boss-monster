package bossmonster.view.constants;

public enum Message {

    /* Input Request */
    INPUT_MONSTER_HP("보스 몬스터의 HP를 입력해주세요."),
    INPUT_PLAYER_NAME("\n" + "플레이어의 이름을 입력해주세요"),
    INPUT_PLAYER_HP_MP("\n" + "플레이어의 HP와 MP를 입력해주세요.(,로 구분)"),
    INPUT_ATTACK_TYPE_SELECT("\n" + "어떤 공격을 하시겠습니까?"),
    INPUT_ATTACK_TYPE("%d. %s"),

    /* Output Message */
    OUTPUT_START_RAID("\n" + "보스 레이드를 시작합니다!"),
    OUTPUT_LINE_ONE("============================"),
    OUTPUT_BOSS_STATUS("BOSS HP [%d/%d]"),
    OUTPUT_LINE_TWO("____________________________"),
    OUTPUT_BOSS_DEFAULT("   ^-^" + "\n" +
                            " / 0 0 \\" + "\n" +
                            "(   \"   )" + "\n" +
                            " \\  -  /" + "\n" +
                            "  - ^ -"),
    OUTPUT_BOSS_DAMAGED("   ^-^" + "\n" +
                        " / x x \\" + "\n" +
                        "(   \"\\  )" + "\n" +
                        " \\  ^  /" + "\n" +
                        "  - ^ -"),
    OUTPUT_BOSS_WIN("   ^-^" + "\n" +
                    " / ^ ^ \\" + "\n" +
                    "(   \"   )" + "\n" +
                    " \\  3  /" + "\n" +
                    "  - ^ -"),
    OUTPUT_PLAYER_STATUS("\n" + "%s HP [%d/%d] MP [%d/%d]"),
    OUTPUT_TURN_RESULT_PLAYER("\n" + "%s을 했습니다. (입힌 데미지: %d)"),
    OUTPUT_TURN_RESULT_BOSS("보스가 공격 했습니다. (입힌 데미지: %d)"),
    OUTPUT_GAME_OVER_PLAYER_WIN("\n" + "%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다."),
    OUTPUT_GAME_OVER_PLAYER_LOSE("\n" + "%s의 HP가 %d이 되었습니다." + "\n" + "보스 레이드에 실패했습니다."),

    /* Error Message */
    ERROR_EMPTY("입력값이 없습니다. 다시 입력해 주세요."),
    ERROR_NOT_INTEGER("숫자만 입력 가능합니다. 다시 입력해 주세요."),
    ERROR_NOT_COMMA("콤마(',')를 통해 구분해서 다시 입력해 주세요."),
    ERROR_ARRAY_SIZE("입력된 항목이 많습니다. 다시 입력해 주세요."),
    ERROR_BOSS_MONSTER_HP("보스몬스터의 HP는 100 이상 300 이하만  설정 가능합니다. 다시 입력해 주세요."),
    ERROR_PLAYER_NAME("플레이어의 이름은 5자 이하만 가능합니다. 다시 입력해 주세요."),
    ERROR_PLAYER_STATUS("플레이어의 HP와 MP의 합은 200으로만 설정 가능합니다. 다시 입력해 주세요."),
    ERROR_PLAYER_ATTACK_TYPE("존재하지 않는 공격 방식입니다. 다시 입력해 주세요."),
    ERROR_PLAYER_MANA_SHORTAGE("마나가 부족합니다. 다시 입력해 주세요.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + message;
    }
}
