package bossmonster.domain;

public class Boss {

    private static final int MIN_DAMAGE = 0;
    private static final int MAX_DAMAGE = 20;
    private static final int NO_DAMAGE = 0;

    private final BossHp bossHp;

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

    public void attackedByPlayer(AttackType attackType) {
        bossHp.attackedBy(attackType);
    }

    public int attackTo(Player player) {
        int bossDamage = damageStrategy.pickDamage(MIN_DAMAGE, MAX_DAMAGE);
        player.attackedBy(bossDamage);
        return bossDamage;
    }

    public boolean isDead() {
        return bossHp.isUnderZero();
    }

    public int zeroDamage() {
        return NO_DAMAGE;
    }
}
