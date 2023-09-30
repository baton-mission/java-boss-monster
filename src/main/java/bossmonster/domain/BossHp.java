package bossmonster.domain;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BossHp bossHp1 = (BossHp) o;
        return currentBossHp == bossHp1.currentBossHp && initialBossHp == bossHp1.initialBossHp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentBossHp, initialBossHp);
    }
}
