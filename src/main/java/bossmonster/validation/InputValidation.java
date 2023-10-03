package bossmonster.validation;

class InputValidation {
    public static void validBossHP(String input) {
        isNumber(input);
        isBetween100And300(input);
    }

    public static void validPlayerName(String input) {
        if(input.length() > 5) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
    }

    public static void validPlayerHPAndMP(String input) {
        String[] stringArr = divideString(input);
        isNumber(stringArr[0]);
        isNumber(stringArr[1]);
        isAdd300(stringArr);
    }

    public static void isAdd300(String[] stringArr) {
        if(Integer.parseInt(stringArr[0]) + Integer.parseInt(stringArr[1]) != 200) {
            throw new IllegalArgumentException("HP와 MP의 합이 200이 되도록 입력해주세요.");
        }
    }


    public static String[] divideString(String input) {
        String[] stringArr;
        try {
            stringArr = input.split(",");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("숫자,숫자 형태로 입력해주세요.");
        }
        return stringArr;
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
