package bossmonster.domain;

public class Boss {

    private static final String ERROR = "[ERROR] ";
    private static final int MAX_HP = 300;
    private static final int MIN_HP = 100;

    private int hp;

    public Boss(String input) {
        int hp = changeToInt(input);
        checkBossHp(hp);
        this.hp = hp;
    }

    private int changeToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "숫자만 입력 가능 합니다.");
        }
    }

    private void checkBossHp(int hp) {
        if (hp > MAX_HP || hp < MIN_HP) {
            throw new IllegalArgumentException(ERROR + "보스의 체력은 100이상 300이하 입니다.");
        }
    }
}
