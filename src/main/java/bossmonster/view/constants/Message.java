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
    OUTPUT_GAME_OVER_PLAYER_LOSE("\n" + "%s의 HP가 %d이 되었습니다." + "\n" + "보스 레이드에 실패했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
