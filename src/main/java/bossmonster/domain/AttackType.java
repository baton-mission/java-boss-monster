package bossmonster.domain;

public enum AttackType {

    PHYSICAL(1, "물리 공격", 10, 10, 0),
    MAGICAL(2, "마법 공격", 20, 0, 30);

    private final int attackTypeCode;
    private final String attackTypeName;
    private final int attackPower;

    private final int recoveryMp;

    private final int reduceMp;

    AttackType(int attackTypeCode, String attackTypeName, int attackPower, int recoveryMp, int reduceMp) {
        this.attackTypeCode = attackTypeCode;
        this.attackTypeName = attackTypeName;
        this.attackPower = attackPower;
        this.recoveryMp = recoveryMp;
        this.reduceMp = reduceMp;
    }


}
