package bossmonster.domain;

import java.util.Objects;

public class PlayerHp {
    private CurrentPlayerHp currentPlayerHp;
    private final InitialPlayerHp initialPlayerHp;

    private PlayerHp(CurrentPlayerHp currentPlayerHp, InitialPlayerHp initialPlayerHp) {
        this.currentPlayerHp = currentPlayerHp;
        this.initialPlayerHp = initialPlayerHp;
    }

    private PlayerHp(int playerHp) {
        this(CurrentPlayerHp.from(playerHp), InitialPlayerHp.from(playerHp));
    }


    public static PlayerHp from(int playerHp) {
        return new PlayerHp(playerHp);
    }


    public int plus(PlayerMp playerMp) {
        return playerMp.plusWithHp(currentPlayerHp.getCurrentPlayerHp());
    }

    public int getCurrentPlayerHp() {
        return currentPlayerHp.getCurrentPlayerHp();
    }

    public int getInitialPlayerHp() {
        return initialPlayerHp.getInitialPlayerHp();
    }

    public void effectedByBossDamage(int damageFromBoss) {
        currentPlayerHp = currentPlayerHp.effectedByBossDamage(damageFromBoss);
    }

    public boolean isUnderMinHp() {
        return currentPlayerHp.isUnderMinHp();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerHp playerHp1 = (PlayerHp) o;
        return currentPlayerHp == playerHp1.currentPlayerHp && initialPlayerHp == playerHp1.initialPlayerHp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlayerHp, initialPlayerHp);
    }
}
