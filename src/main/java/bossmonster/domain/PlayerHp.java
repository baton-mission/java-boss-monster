package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.PLAYER_HP_EXCEPTION_MESSAGE;

import java.util.Objects;

public class PlayerHp {

    private static final int MIN_HP = 0;
    private int playerHp;
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

    public static PlayerHp fromTest(int playerHp, int initialPlayerHp) {
        return new PlayerHp(playerHp, initialPlayerHp);
    }

    public int plus(PlayerMp playerMp) {
        return playerMp.plusWithHp(playerHp);
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public int getInitialPlayerHp() {
        return initialPlayerHp;
    }

    public void effectedByBossDamage(int damageFromBoss) {
        int effectedPlayerHp = effectedPlayerHpFromBossDamage(damageFromBoss);
        setPlayerHpNotToUnderMin(effectedPlayerHp);
    }

    private void setPlayerHpNotToUnderMin(int effectedPlayerHp) {
        this.playerHp = Math.max(MIN_HP, effectedPlayerHp);
    }

    private int effectedPlayerHpFromBossDamage(int damageFromBoss) {
        return playerHp - damageFromBoss;
    }

    public boolean isUnderMinHp() {
        return playerHp <= MIN_HP;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerHp playerHp1 = (PlayerHp) o;
        return playerHp == playerHp1.playerHp && initialPlayerHp == playerHp1.initialPlayerHp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerHp, initialPlayerHp);
    }
}
