package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.PLAYER_HP_EXCEPTION_MESSAGE;

public class PlayerHp {

    private static final int MIN_HP = 0;
    private final int playerHp;
    private final int initialPlayerHp;

    private PlayerHp(int playerHp, int initialPlayerHp) {
        validate(playerHp);
        this.playerHp = playerHp;
        this.initialPlayerHp = initialPlayerHp;
    }

    private PlayerHp(int playerHp) {
        this(playerHp, playerHp);
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

    public static PlayerHp from(int playerHp) {
        return new PlayerHp(playerHp);
    }

    public int plus(PlayerMp playerMp) {
        return playerMp.plus(playerHp);
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public int getInitialPlayerHp() {
        return initialPlayerHp;
    }
}
