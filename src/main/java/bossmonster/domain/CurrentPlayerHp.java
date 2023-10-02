package bossmonster.domain;

import java.util.Objects;

public final class CurrentPlayerHp {

    private static final int MIN_HP = 0;

    private final int currentPlayerHp;

    private CurrentPlayerHp(int currentPlayerHp) {
        this.currentPlayerHp = currentPlayerHp;
    }

    public static CurrentPlayerHp from(int currentPlayerHp) {
        return new CurrentPlayerHp(currentPlayerHp);
    }

    public CurrentPlayerHp effectedByBossDamage(int damageFromBoss) {
        int effectedPlayerHp = effectedPlayerHpFromBossDamage(damageFromBoss);
        int currentPlayerHp = calculatePlayerHpNotToUnderMin(effectedPlayerHp);
        return new CurrentPlayerHp(currentPlayerHp);
    }

    private int effectedPlayerHpFromBossDamage(int damageFromBoss) {
        return currentPlayerHp - damageFromBoss;
    }

    private int calculatePlayerHpNotToUnderMin(int effectedPlayerHp) {
        return Math.max(MIN_HP, effectedPlayerHp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentPlayerHp that = (CurrentPlayerHp) o;
        return currentPlayerHp == that.currentPlayerHp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlayerHp);
    }

    public int getCurrentPlayerHp() {
        return currentPlayerHp;
    }

    public boolean isUnderMinHp() {
        return currentPlayerHp <= MIN_HP;
    }

}
