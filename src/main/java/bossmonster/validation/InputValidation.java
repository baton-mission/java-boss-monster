package bossmonster.validation;

import java.util.*;
public class InputValidation {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static int validBossHP(String input) {
        int inputNumber = isNumber(input);
        isBetween100And300(inputNumber);
        return inputNumber;
    }

    public static String validPlayerName(String input) {
        if(input.length() > 5) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "5자 이하의 이름을 입력해주세요.");
        }
        return input;
    }

    public static List<Integer> validPlayerHPAndMP(String input) {
        String[] stringArr = divideString(input);
        List<Integer> playerHPMP = List.of(isNumber(stringArr[0]), isNumber(stringArr[1]));
        isAdd300(playerHPMP);
        return playerHPMP;
    }

    public static void isAdd300(List<Integer> playerHPMP) {
        if(playerHPMP.get(0) + playerHPMP.get(1) != 200) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "HP와 MP의 합이 200이 되도록 입력해주세요.");
        }
    }


    public static String[] divideString(String input) {
        String[] stringArr;
        try {
            stringArr = input.split(",");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자,숫자 형태로 입력해주세요.");
        }
        return stringArr;
    }

    public static void isBetween100And300(int input) {
        if(input < 100 || 300 < input) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "100 ~ 300 사이의 숫자를 입력해주세요.");
        }
    }

    public static int isNumber(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자를 입력해주세요.");
        }
        return inputNumber;
    }

}
