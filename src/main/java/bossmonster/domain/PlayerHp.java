package bossmonster.domain;

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
}
