package bossmonster.exception;

import bossmonster.view.constants.Message;

public class Validator {

    public static String validateInputOfNumber(String inputValue) {
        validateEmpty(inputValue);
        validateInteger(inputValue);
        return inputValue;
    }

    public static String validatePlayerName(String inputValue) {
        validateEmpty(inputValue);
        validateRangeOfPlayerName(inputValue);
        return inputValue;
    }

    public static String[] validateInputOfNumbers(String inputValue) {
        validateSeparated(inputValue);
        String[] separatedValue = inputValue.split(",");
        validateArray(separatedValue);
        for (String value : separatedValue) {
            validateEmpty(value);
            validateInteger(value);
        }
        return separatedValue;
    }

    public static int validateBossMonster(int hp) {
        return validateRangeOfMonster(hp);
    }

    public static void validatePlayerStatus(int hp, int mp) {
        if (hp + mp != 200) {
            throw new IllegalArgumentException(Message.ERROR_PLAYER_STATUS.getErrorMessage());
        }
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR_EMPTY.getErrorMessage());
        }
    }

    private static void validateInteger(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NOT_INTEGER.getErrorMessage());
        }
    }

    private static void validateSeparated(String inputValue) {
        if (!inputValue.contains(",")) {
            throw new IllegalArgumentException(Message.ERROR_NOT_COMMA.getErrorMessage());
        }
    }

    private static void validateArray(String[] inputValue) {
        if (inputValue.length != 2) {
            throw new IllegalArgumentException(Message.ERROR_ARRAY_SIZE.getErrorMessage());
        }
    }

    private static int validateRangeOfMonster(int hp) {
        if (hp < 100 || hp > 300) {
            throw new IllegalArgumentException(Message.ERROR_BOSS_MONSTER_HP.getErrorMessage());
        }
        return hp;
    }

    private static void validateRangeOfPlayerName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Message.ERROR_PLAYER_NAME.getErrorMessage());
        }
    }
}
