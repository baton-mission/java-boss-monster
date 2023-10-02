package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.BOSS_HP_RANGE_EXCEPTION_MESSAGE;

import java.util.Objects;

public final class InitialBossHp {

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 300;

    private final int initialBossHp;

    private InitialBossHp(int initialBossHp) {
        validate(initialBossHp);
        this.initialBossHp = initialBossHp;
    }

    public static InitialBossHp from(int initialBossHp) {
        return new InitialBossHp(initialBossHp);
    }

    private void validate(int bossHp) {
        validateRange(bossHp);
    }

    private void validateRange(int bossHp) {
        if (!isRightHpRange(bossHp)) {
            throw new IllegalArgumentException(BOSS_HP_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isRightHpRange(int bossHp) {
        return bossHp >= MIN_HP && bossHp <= MAX_HP;
    }

    public int getInitialBossHp() {
        return initialBossHp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InitialBossHp that = (InitialBossHp) o;
        return initialBossHp == that.initialBossHp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialBossHp);
    }
}
