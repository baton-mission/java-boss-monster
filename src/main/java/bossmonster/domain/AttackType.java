package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.ATTACK_TYPE_EXCEPTION_MESSAGE;
import static bossmonster.domain.MpStatus.RECOVERY;
import static bossmonster.domain.MpStatus.REDUCE;

import java.util.HashMap;
import java.util.Map;

public enum AttackType {

    PHYSICAL(1, "물리 공격", 10, RECOVERY),
    MAGICAL(2, "마법 공격", 20, REDUCE);

    private static final Map<Integer, AttackType> CODE_TO_TYPE_MAP = new HashMap<>();

    static {
        for (AttackType type : values()) {
            CODE_TO_TYPE_MAP.put(type.attackTypeCode, type);
        }
    }

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
        return CODE_TO_TYPE_MAP.getOrDefault(attackTypeCode, throwException());
    }

    private static AttackType throwException() {
        throw new IllegalArgumentException(ATTACK_TYPE_EXCEPTION_MESSAGE);
    }

    public int effectMp(int playerMp) {
        return this.mpStatus.effect(playerMp);
    }

    public int attack(int bossHp) {
        return bossHp - this.attackPower;
    }

    public int getAttackTypeCode() {
        return attackTypeCode;
    }

    public String getAttackTypeName() {
        return attackTypeName;
    }

    public int getAttackDamage() {
        return attackPower;
    }
}
