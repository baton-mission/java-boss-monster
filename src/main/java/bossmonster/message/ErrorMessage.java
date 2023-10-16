package bossmonster.message;

public enum ErrorMessage {

    ERROR("[ERROR] "),
    NOT_NUMBER("숫자를 입력해주세요"),
    NOT_BLANCK("값은 빈칸이면 안됩니다."),
    WRONG_PLAYER_HP_MP_FORMAT("숫자,숫자 형식으로 입력해주세요");
    ;


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public static String getErrorMessage(ErrorMessage errorMessage) {
        return ERROR.message + errorMessage.message;
    }
}
