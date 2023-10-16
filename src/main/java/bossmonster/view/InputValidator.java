package bossmonster.view;

import bossmonster.domain.attack.AttackType;

import java.lang.constant.Constable;
import java.util.Arrays;

public class InputValidator {
    public static void isNumeric(String input) {
        boolean allMatch = input.chars().allMatch(e -> ('0' <= e && e <= '9'));
        if (!allMatch) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }
    }

    public static void hasSpace(String input) {
        boolean isMatch = input.chars().anyMatch(e -> e == ' ');
        if (isMatch) {
            throw new IllegalArgumentException("[ERROR] 이름에는 공백이 포함되면 안됩니다.");
        }
    }

    public static void isCorrectSize(String input, String delim, int targetSize) {
        String[] split = input.split(delim);
        if (targetSize != split.length) {
            throw new IllegalArgumentException("[ERROR]" + "(" + delim + ")" + "를 통해 " + targetSize + "개를 입력해야 합니다.");
        }
    }

    public static void isValidAttackNumber(String input, Object obj) {
        int number = Integer.parseInt(input);
        Constable type = AttackType.createPlayerAttack(number);
        
        boolean isValid = Arrays.stream(AttackType.Player.values()).
                anyMatch(attack -> attack.getTypeNumber() == number);

        if (!isValid) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 번호입니다.");
        }
    }
}
