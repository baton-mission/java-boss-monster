package bossmonster.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum AttackType {
    PHYSICAL(1, 10, 10, "물리"),
    MAGICAL(2, 20, -30, "마법");

    public static final String INVALID_ATTACK_TYPE = "공격 타입은 1 또는 2를 입력해주세요.";
    private final int type;
    private final int damage;
    private final int mpChange;
    private final String message;
    private static final Map<Integer, AttackType> cache;

    static {
        cache = Arrays.stream(AttackType.values())
                .collect(Collectors.toMap((attackType) -> attackType.type, (attackType -> attackType)));
    }

    AttackType(int type, int damage, int mpChange, String message) {
        this.type = type;
        this.damage = damage;
        this.mpChange = mpChange;
        this.message = message;
    }

    public static AttackType fromType(int type) {
        if (!cache.containsKey(type)) {
            throw new IllegalArgumentException(INVALID_ATTACK_TYPE);
        }
        return cache.get(type);
    }

    public int getDamage() {
        return damage;
    }

    public int getMpChange() {
        return mpChange;
    }

    public String getMessage() {
        return message;
    }
}
