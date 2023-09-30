package bossmonster.exception;

import bossmonster.domain.Player;

import java.awt.print.PrinterIOException;
import java.util.StringTokenizer;

public class Validator {

    final String PREFIX = "[ERROR] ";

    public void validateBossStatus(String hp) {
        validateDigit(hp);
    }

    public void validatePlayerStatus(String status) {
        StringTokenizer st = new StringTokenizer(status, ",");
        String hp = st.nextToken();

        if (!st.hasMoreTokens()) {
            throw new IllegalArgumentException(PREFIX + "HP와 MP를 콤마(,)로 구분하여 입력해주세요. (예: 100,100)");
        }

        String mp = st.nextToken();
        validateDigit(hp);
        validateDigit(mp);
    }

    public void validateAttackType(String attackType) {
        validateDigit(attackType);
    }

    private void validateDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PREFIX + "입력이 잘못되었습니다. 다시 입력해주세요.");
        }
    }
}
