package bossmonster.domain;

public class PlayerHp {

    private static final int MIN_HP = 0;
    private final int playerHp;

    private PlayerHp(int playerHp) {
        validate(playerHp);
        this.playerHp = playerHp;
    }

    private void validate(int playerHp) {
        validateUnderMinHp(playerHp);
    }

    private void validateUnderMinHp(int playerHp) {
        if (isUnderMinHp(playerHp)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isUnderMinHp(int playerHp) {
        return playerHp <= MIN_HP;
    }

    public static PlayerHp from(int playerHp) {
        return new PlayerHp(playerHp);
    }
}
