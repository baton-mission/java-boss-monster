package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.PLAYER_MP_EXCEPTION_MESSAGE;
import static bossmonster.domain.ExceptionMessage.SKILL_MP_EXCEPTION_MESSAGE;

import java.util.Objects;

public class PlayerMp {

    private static final int MIN_MP = 0;

    private int playerMp;
    private final int initialPlayerMp;

    private PlayerMp(int playerMp, int initialPlayerMp) {
        validate(playerMp);
        this.playerMp = playerMp;
        this.initialPlayerMp = initialPlayerMp;
    }

    private PlayerMp(int playerMp) {
        this(playerMp, playerMp);
    }

    public static PlayerMp fromTest(int playerMp, int initialPlayerMp) {
        return new PlayerMp(playerMp, initialPlayerMp);
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
        return playerMp < MIN_MP;
    }

    public static PlayerMp from(int playerMp) {
        return new PlayerMp(playerMp);
    }

    public int plus(int playerHp) {
        return playerHp + playerMp;
    }

    public int getPlayerMp() {
        return playerMp;
    }

    public int getInitialPlayerMp() {
        return initialPlayerMp;
    }

    public void effectedMpByAttackType(AttackType attackType) {
        int effectedPlayerMp = attackType.effectMp(playerMp);
        if (isUnderMinMp(effectedPlayerMp)) {
            throw new IllegalArgumentException(SKILL_MP_EXCEPTION_MESSAGE);
        }
        setPlayerMpNotToOverMax(effectedPlayerMp);
    }

    private void setPlayerMpNotToOverMax(int effectedPlayerMp) {
        this.playerMp = Math.min(effectedPlayerMp, initialPlayerMp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerMp playerMp1 = (PlayerMp) o;
        return playerMp == playerMp1.playerMp && initialPlayerMp == playerMp1.initialPlayerMp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerMp, initialPlayerMp);
    }
}
