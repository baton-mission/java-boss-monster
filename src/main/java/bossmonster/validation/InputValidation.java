package bossmonster.validation;

class InputValidation {
    public static void validBossHP(String input) {
        isNumber(input);
        isBetween100And300(input);
    }

    public static void isBetween100And300(String input) {
        int inputInteger = Integer.parseInt(input);
        if(inputInteger < 100 || 300 < inputInteger) {
            throw new IllegalArgumentException("100 ~ 300 사이의 숫자를 입력해주세요.");
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

}
