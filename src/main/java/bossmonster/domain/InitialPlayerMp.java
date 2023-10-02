package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.PLAYER_MP_EXCEPTION_MESSAGE;

public final class InitialPlayerMp {

    private static final int MIN_MP = 0;
    private final int initialPlayerMp;

    private InitialPlayerMp(int initialPlayerMp) {
        validate(initialPlayerMp);
        this.initialPlayerMp = initialPlayerMp;
    }

    private void validate(int initialPlayerMp) {
        validateUnderMinMp(initialPlayerMp);
    }

    private void validateUnderMinMp(int initialPlayerMp) {
        if (isUnderMinMp(initialPlayerMp)) {
            throw new IllegalArgumentException(PLAYER_MP_EXCEPTION_MESSAGE);
        }
    }

    private boolean isUnderMinMp(int initialPlayerMp) {
        return initialPlayerMp < MIN_MP;
    }

    public static InitialPlayerMp from(int initialPlayerMp) {
        return new InitialPlayerMp(initialPlayerMp);
    }

    public int plusWithHp(int playerHp) {
        return initialPlayerMp + playerHp;
    }

    public int getNormalizedPlayerMp(int effectedCurrentPlayerMp) {
        if (isBiggerThanInitialMp(effectedCurrentPlayerMp)) {
            return initialPlayerMp;
        }
        return effectedCurrentPlayerMp;
    }

    private boolean isBiggerThanInitialMp(int effectedCurrentPlayerMp) {
        return effectedCurrentPlayerMp > initialPlayerMp;
    }

    public int getInitialPlayerMp() {
        return initialPlayerMp;
    }

}
