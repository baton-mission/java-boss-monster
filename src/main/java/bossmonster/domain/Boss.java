package bossmonster.domain;

public class Boss {

    private BossHp bossHp;

    private final DamageStrategy damageStrategy;

    private Boss(BossHp bossHp, DamageStrategy damageStrategy) {
        this.bossHp = bossHp;
        this.damageStrategy = damageStrategy;
    }

    private Boss(int bossHp, DamageStrategy damageStrategy) {
        this(BossHp.from(bossHp), damageStrategy);
    }

    public static Boss from(int bossHp, DamageStrategy damageStrategy) {
        return new Boss(bossHp, damageStrategy);
    }

    public int getBossHp() {
        return bossHp.getBossHp();
    }

    public int getInitialBossHp() {
        return bossHp.getInitialBossHp();
    }

    public void effectedHpBy(AttackType attackType) {
        bossHp = bossHp.effectedBy(attackType);
    }
}
