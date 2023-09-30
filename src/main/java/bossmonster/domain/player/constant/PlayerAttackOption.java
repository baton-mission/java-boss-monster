package bossmonster.domain.player.constant;

public enum PlayerAttackOption {
    PHYSICAL(0, 10,  10),
    MAGIC(30, 0,  20);

    private final int needMp;
    private final int recoveryMp;
    private final int damage;

    PlayerAttackOption(
            int needMp,
            int recoveryMp,
            int damage
    ) {
        this.needMp = needMp;
        this.recoveryMp = recoveryMp;
        this.damage = damage;
    }

    public int getNeedMp() {
        return needMp;
    }

    public int getRecoveryMp() {
        return recoveryMp;
    }

    public int getDamage() {
        return damage;
    }
}
