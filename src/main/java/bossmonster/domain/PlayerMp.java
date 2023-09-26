package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.PLAYER_MP_EXCEPTION_MESSAGE;

public class PlayerMp {

    private static final int MIN_MP = 0;

    private final int playerMp;

    private PlayerMp(int playerMp) {
        validate(playerMp);
        this.playerMp = playerMp;
    }

    private void validate(int playerMp) {
        validateUnderMinMp(playerMp);
    }

    private void validateUnderMinMp(int playerMp) {
        if (isUnderMinMp(playerMp)) {
            throw new IllegalArgumentException(PLAYER_MP_EXCEPTION_MESSAGE);
        }
    }

    private boolean isUnderMinMp(int playerMp) {
        return playerMp <= MIN_MP;
    }

    public static PlayerMp from(int playerMp) {
        return new PlayerMp(playerMp);
    }

    public int plus(int playerHp) {
        return playerHp + playerMp;
    }
}
