package bossmonster.domain;

public class PlayerHp {

    private final InitialPlayerHp initialPlayerHp;
    private CurrentPlayerHp currentPlayerHp;

    private PlayerHp(int playerHp) {
        this(CurrentPlayerHp.from(playerHp), InitialPlayerHp.from(playerHp));
    }

    private PlayerHp(CurrentPlayerHp currentPlayerHp, InitialPlayerHp initialPlayerHp) {
        this.currentPlayerHp = currentPlayerHp;
        this.initialPlayerHp = initialPlayerHp;
    }

    public static PlayerHp from(int playerHp) {
        return new PlayerHp(playerHp);
    }

    public int plus(PlayerMp playerMp) {
        return playerMp.plusWithHp(currentPlayerHp.getCurrentPlayerHp());
    }

    public void effectedByBossDamage(int damageFromBoss) {
        currentPlayerHp = currentPlayerHp.effectedByBossDamage(damageFromBoss);
    }

    public int getCurrentPlayerHp() {
        return currentPlayerHp.getCurrentPlayerHp();
    }

    public int getInitialPlayerHp() {
        return initialPlayerHp.getInitialPlayerHp();
    }

    public boolean isUnderMinHp() {
        return currentPlayerHp.isUnderMinHp();
    }

}
