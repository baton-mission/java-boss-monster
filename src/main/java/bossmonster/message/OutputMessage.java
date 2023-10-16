package bossmonster.message;

public enum OutputMessage {

    START_GAME("보스 레이드를 시작합니다!"),
    EQUALS_LINE("============================"),
    UNDERSCORE_LINE("____________________________"),
    MONSTER_HP("BOSS HP [%d/%d]"),
    PLAYER_HP_AND_MP("%s HP [%d/%d] MP [%d/%d]"),

    GAME_LOSE("%s의 HP가 0이 되었습니다.\n"
            + "보스 레이드에 실패했습니다."),
    GAME_WIN("%s님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다."),
    MONSTER_ATTACK("보스가 공격 했습니다. (입힌 데미지: %d)"),
    PLAYER_ATTACK("%s을 했습니다. (입힌 데미지: %d)");


    ;
    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
