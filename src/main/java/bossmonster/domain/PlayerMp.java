package bossmonster.domain;

public class PlayerMp {

    private final InitialPlayerMp initialPlayerMp;
    private CurrentPlayerMp currentPlayerMp;

    private PlayerMp(int playerMp) {
        this(CurrentPlayerMp.from(playerMp), InitialPlayerMp.from(playerMp));
    }

    private PlayerMp(CurrentPlayerMp currentPlayerMp, InitialPlayerMp initialPlayerMp) {
        this.currentPlayerMp = currentPlayerMp;
        this.initialPlayerMp = initialPlayerMp;
    }

    public static PlayerMp from(int playerMp) {
        return new PlayerMp(playerMp);
    }

    public int plusWithHp(int playerHp) {
        return initialPlayerMp.plusWithHp(playerHp);
    }

    public void effectedMpByAttackType(AttackType attackType) {
        this.currentPlayerMp = currentPlayerMp.effectMpByAttackType(attackType, initialPlayerMp);
    }

    public int getPlayerMp() {
        return currentPlayerMp.getCurrentPlayerMp();
    }

    public int getInitialPlayerMp() {
        return initialPlayerMp.getInitialPlayerMp();
    }

}
