package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.ATTACK_TYPE_EXCEPTION_MESSAGE;
import static bossmonster.domain.MpStatus.RECOVERY;
import static bossmonster.domain.MpStatus.REDUCE;

import java.util.stream.Stream;

public enum AttackType {

    PHYSICAL(1, "물리 공격", 10, RECOVERY),
    MAGICAL(2, "마법 공격", 20, REDUCE);

    private final int attackTypeCode;
    private final String attackTypeName;
    private final int attackPower;

    private final MpStatus mpStatus;

    AttackType(int attackTypeCode, String attackTypeName, int attackPower, MpStatus mpStatus) {
        this.attackTypeCode = attackTypeCode;
        this.attackTypeName = attackTypeName;
        this.attackPower = attackPower;
        this.mpStatus = mpStatus;
    }

    public static AttackType fromCode(int attackTypeCode) {
        return Stream.of(values())
                .filter(attackType -> attackType.attackTypeCode == attackTypeCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ATTACK_TYPE_EXCEPTION_MESSAGE));
    }


    public int getAttackTypeCode() {
        return attackTypeCode;
    }

    public String getAttackTypeName() {
        return attackTypeName;
    }

    public int effectMp(int playerMp) {
        return this.mpStatus.effect(playerMp);
    }

    public int effectHp(int bossHp) {
        return bossHp - this.attackPower;
    }
}
