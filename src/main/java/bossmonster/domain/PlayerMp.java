package bossmonster.domain;

public class PlayerMp {

    private CurrentPlayerMp currentPlayerMp;
    private final InitialPlayerMp initialPlayerMp;

    private PlayerMp(CurrentPlayerMp currentPlayerMp, InitialPlayerMp initialPlayerMp) {
        this.currentPlayerMp = currentPlayerMp;
        this.initialPlayerMp = initialPlayerMp;
    }

    private PlayerMp(int playerMp) {
        this(CurrentPlayerMp.from(playerMp), InitialPlayerMp.from(playerMp));
    }


    public static PlayerMp from(int playerMp) {
        return new PlayerMp(playerMp);
    }

    public int plusWithHp(int playerHp) {
        return initialPlayerMp.plusWithHp(playerHp);
    }

    public int getPlayerMp() {
        return currentPlayerMp.getCurrentPlayerMp();
    }

    public int getInitialPlayerMp() {
        return initialPlayerMp.getInitialPlayerMp();
    }

    public void effectedMpByAttackType(AttackType attackType) {
        this.currentPlayerMp = currentPlayerMp.effectMpByAttackType(attackType, initialPlayerMp);
    }

}
