package bossmonster.exception;

import java.awt.print.PrinterIOException;

public class Validator {

    final String PREFIX = "[ERROR] ";
    final String regex = "^[^0]\\d*";

    public void validateBossStatus(String hp) {
        if (!hp.matches(regex)) {
            throw new IllegalArgumentException(PREFIX + "보스 체력은 100이상, 300이하의 정수로 입력해주세요.");
        }

        int hpNum = Integer.parseInt(hp);
        if (hpNum < 100 || hpNum > 300) {
            throw new IllegalArgumentException(PREFIX + "보스 체력은 100이상, 300이하여야합니다.");
        }
    }

    public void validatePlayerName(String playerName) {
        if (playerName.length() > 5) {
            throw new IllegalArgumentException(PREFIX + "플레이어의 이름은 5자 이하만 가능합니다.");
        }
    }
}
