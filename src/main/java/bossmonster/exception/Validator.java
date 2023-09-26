package bossmonster.exception;

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
}
