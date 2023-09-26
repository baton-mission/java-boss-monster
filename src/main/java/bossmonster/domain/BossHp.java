package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.BOSS_HP_RANGE_EXCEPTION_MESSAGE;

public class BossHp {

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 300;

    private final int bossHp;

    private BossHp(int bossHp) {
        validate(bossHp);
        this.bossHp = bossHp;
    }

    private void validate(int bossHp) {
        validateRange(bossHp);
    }

    private void validateRange(int bossHp) {
        if (isRightHpRange(bossHp)) {
            throw new IllegalArgumentException(BOSS_HP_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isRightHpRange(int bossHp) {
        return bossHp < MIN_HP || bossHp > 300;
    }

    public static BossHp from(int bossHp) {
        return new BossHp(bossHp);
    }
}
