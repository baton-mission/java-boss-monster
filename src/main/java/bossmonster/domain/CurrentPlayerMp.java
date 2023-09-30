package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.SKILL_MP_EXCEPTION_MESSAGE;

import java.util.Objects;

public final class CurrentPlayerMp {

    private static final int MIN_CURRENT_MP_TO_USE = 0;
    private final int currentPlayerMp;

    private CurrentPlayerMp(int currentPlayerMp) {
        validate(currentPlayerMp);
        this.currentPlayerMp = currentPlayerMp;
    }

    private void validate(int currentPlayerMp) {
        validateUnderMinMp(currentPlayerMp);
    }

    private void validateUnderMinMp(int currentPlayerMp) {
        if (isUnderMinMp(currentPlayerMp)) {
            throw new IllegalArgumentException(SKILL_MP_EXCEPTION_MESSAGE);
        }
    }

    private boolean isUnderMinMp(int effectedCurrentPlayerMp) {
        return effectedCurrentPlayerMp < MIN_CURRENT_MP_TO_USE;
    }

    public static CurrentPlayerMp from(int currentPlayerMp) {
        return new CurrentPlayerMp(currentPlayerMp);
    }

    public int getCurrentPlayerMp() {
        return currentPlayerMp;
    }

    public CurrentPlayerMp effectMpByAttackType(AttackType attackType, InitialPlayerMp initialPlayerMp) {
        int effectedCurrentPlayerMp = attackType.effectMp(currentPlayerMp);
        int normalizedPlayerMp = initialPlayerMp.getNormalizedPlayerMp(effectedCurrentPlayerMp);
        return new CurrentPlayerMp(normalizedPlayerMp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentPlayerMp that = (CurrentPlayerMp) o;
        return currentPlayerMp == that.currentPlayerMp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlayerMp);
    }
}
