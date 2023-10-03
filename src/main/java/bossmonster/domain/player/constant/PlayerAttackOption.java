package bossmonster.domain.player.constant;

public enum PlayerAttackOption {
    PHYSICAL("물리 공격", 0, 10,  10),
    MAGIC("마법 공격", 30, 0,  20);

    private final String attackName;
    private final int needMp;
    private final int recoveryMp;
    private final int damage;

    PlayerAttackOption(
            String attackName,
            int needMp,
            int recoveryMp,
            int damage
    ) {
        this.attackName = attackName;
        this.needMp = needMp;
        this.recoveryMp = recoveryMp;
        this.damage = damage;
    }

    public String getAttackName() {
        return attackName;
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
