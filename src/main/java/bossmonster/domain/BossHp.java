package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.BOSS_HP_RANGE_EXCEPTION_MESSAGE;

public class BossHp {

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 300;
    private static final int BOSS_ZERO_HP = 0;

    private int bossHp;
    private final int initialBossHp;

    private BossHp(int bossHp, int initialBossHp) {
        validate(bossHp);
        this.bossHp = bossHp;
        this.initialBossHp = initialBossHp;
    }

    private BossHp(int bossHp) {
        this(bossHp, bossHp);
    }

    private void validate(int bossHp) {
        validateRange(bossHp);
    }

    private void validateRange(int bossHp) {
        if (!isRightHpRange(bossHp)) {
            throw new IllegalArgumentException(BOSS_HP_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isRightHpRange(int bossHp) {
        return bossHp >= MIN_HP && bossHp <= MAX_HP;
    }

    public static BossHp from(int bossHp) {
        return new BossHp(bossHp);
    }

    public int getBossHp() {
        return bossHp;
    }

    public int getInitialBossHp() {
        return initialBossHp;
    }

    public void attackedBy(AttackType attackType) {
        int bossHpFromAttack = attackType.attack(bossHp);
        setBossMpNotToUnderMin(bossHpFromAttack);
    }

    private void setBossMpNotToUnderMin(int bossHpFromAttack) {
        this.bossHp = Math.max(BOSS_ZERO_HP, bossHpFromAttack);
    }

    public boolean isUnderZero() {
        return bossHp <= 0;
    }
}
