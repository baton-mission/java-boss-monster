package bossmonster.domain;

import java.util.Objects;

public final class CurrentBossHp {

    private static final int BOSS_ZERO_HP = 0;

    private final int currentBossHp;

    private CurrentBossHp(int currentBossHp) {
        this.currentBossHp = currentBossHp;
    }

    public static CurrentBossHp from(int currentBossHp) {
        return new CurrentBossHp(currentBossHp);
    }

    public int getCurrentBossHp() {
        return currentBossHp;
    }

    public CurrentBossHp attackedBy(AttackType attackType) {
        int bossHpFromAttack = attackType.attack(currentBossHp);
        int currentBossHp = calculateBossHpNotToUnderMin(bossHpFromAttack);
        return new CurrentBossHp(currentBossHp);
    }

    private int calculateBossHpNotToUnderMin(int bossHpFromAttack) {
        return Math.max(BOSS_ZERO_HP, bossHpFromAttack);
    }

    public boolean isUnderZero() {
        return currentBossHp <= BOSS_ZERO_HP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentBossHp that = (CurrentBossHp) o;
        return currentBossHp == that.currentBossHp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentBossHp);
    }
}
