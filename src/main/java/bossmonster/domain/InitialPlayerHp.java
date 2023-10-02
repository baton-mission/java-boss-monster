package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.PLAYER_HP_EXCEPTION_MESSAGE;

public final class InitialPlayerHp {

    private static final int MIN_HP = 0;

    private final int initialPlayerHp;

    private InitialPlayerHp(int initialPlayerHp) {
        validate(initialPlayerHp);
        this.initialPlayerHp = initialPlayerHp;
    }

    private void validate(int playerHp) {
        validateUnderMinHp(playerHp);
    }

    private void validateUnderMinHp(int playerHp) {
        if (isUnderMinHp(playerHp)) {
            throw new IllegalArgumentException(PLAYER_HP_EXCEPTION_MESSAGE);
        }
    }

    private boolean isUnderMinHp(int playerHp) {
        return playerHp <= MIN_HP;
    }

    public static InitialPlayerHp from(int initialPlayerHp) {
        return new InitialPlayerHp(initialPlayerHp);
    }

    public int getInitialPlayerHp() {
        return initialPlayerHp;
    }
}
