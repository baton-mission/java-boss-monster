package bossmonster.util;

import bossmonster.domain.Status;

import static bossmonster.util.Constants.*;
import static bossmonster.util.ErrorMessage.*;

public class ErrorChecker {

    public static void checkSum(int[] temp) {
        int sum = temp[0] + temp[1];
        if (sum != HP_MP_SUM) {
            throw new IllegalArgumentException(ERROR + SUM_EXCEPTION);
        }
    }

    public static void checkName(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(ERROR + MAX_LENGTH);
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR + EMPTY);
        }
    }

    public static int changeToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NUMERIC);
        }
    }

    public static void checkBossHp(int hp) {
        if (hp > MAX_HP || hp < MIN_HP) {
            throw new IllegalArgumentException(ERROR + HP_RANGE);
        }
    }

    public static void checkMana(Status status, int manaCost) {
        if (status.getMp() + manaCost < 0) {
            throw new IllegalArgumentException(ERROR + MANA_LACK);
        }
    }
}
