package bossmonster.domain;

public class BossHp {

    private final InitialBossHp initialBossHp;
    private CurrentBossHp currentBossHp;

    private BossHp(int bossHp) {
        this(CurrentBossHp.from(bossHp), InitialBossHp.from(bossHp));
    }

    private BossHp(CurrentBossHp currentBossHp, InitialBossHp initialBossHp) {
        this.currentBossHp = currentBossHp;
        this.initialBossHp = initialBossHp;
    }

    public static BossHp from(int bossHp) {
        return new BossHp(bossHp);
    }

    public void attackedBy(AttackType attackType) {
        this.currentBossHp = currentBossHp.attackedBy(attackType);
    }

    public int getCurrentBossHp() {
        return currentBossHp.getCurrentBossHp();
    }

    public int getInitialBossHp() {
        return initialBossHp.getInitialBossHp();
    }

    public boolean isUnderZero() {
        return currentBossHp.isUnderZero();
    }

}
