package bossmonster.domain;

public class Boss {

    private static final int MIN_DAMAGE = 0;
    private static final int MAX_DAMAGE = 20;

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

    public int attackTo(Player player) {
        int bossDamage = damageStrategy.pickDamage(MIN_DAMAGE, MAX_DAMAGE);
        player.effectedHpBy(bossDamage);
        return bossDamage;
    }

    public boolean isDead() {
        return bossHp.isUnderZero();
    }
}
