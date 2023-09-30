package bossmonster.domain;

public class BossHp {

    private CurrentBossHp currentBossHp;
    private final InitialBossHp initialBossHp;

    private BossHp(CurrentBossHp currentBossHp, InitialBossHp initialBossHp) {
        this.currentBossHp = currentBossHp;
        this.initialBossHp = initialBossHp;
    }

    private BossHp(int bossHp) {
        this(CurrentBossHp.from(bossHp), InitialBossHp.from(bossHp));
    }


    public static BossHp from(int bossHp) {
        return new BossHp(bossHp);
    }

    public int getCurrentBossHp() {
        return currentBossHp.getCurrentBossHp();
    }

    public int getInitialBossHp() {
        return initialBossHp.getInitialBossHp();
    }

    public void attackedBy(AttackType attackType) {
        this.currentBossHp = currentBossHp.attackedBy(attackType);
    }


    public boolean isUnderZero() {
        return currentBossHp.isUnderZero();
    }


}
