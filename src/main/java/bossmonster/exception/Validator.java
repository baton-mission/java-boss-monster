package bossmonster.exception;

public class Validator {

    public static String validateInputOfNumber(String inputValue) {
        validateEmpty(inputValue);
        validateInteger(inputValue);
        return inputValue;
    }

    public static String validateInputOfString(String inputValue) {
        validateEmpty(inputValue);
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

    public static String validatePlayerName(String name) {
        return validateRangeOfPlayerName(name);
    }

    public static void validatePlayerStatus(int hp, int mp) {
        if (hp + mp != 200) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInteger(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSeparated(String inputValue) {
        if (!inputValue.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateArray(String[] inputValue) {
        if (inputValue.length != 2) {
            throw new IllegalArgumentException();
        }
    }

    private static int validateRangeOfMonster(int hp) {
        if (hp < 100 || hp > 300) {
            throw new IllegalArgumentException();
        }
        return hp;
    }

    private static String validateRangeOfPlayerName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return name;
    }
}
