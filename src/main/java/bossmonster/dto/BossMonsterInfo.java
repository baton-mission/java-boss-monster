package bossmonster.dto;

public class BossMonsterInfo {
    private final int maximumBossMonsterHp;
    private final int currentBossMonsterHp;

    private BossMonsterInfo(
            final int maximumBossMonsterHp,
            final int currentBossMonsterHp
    ) {
        this.maximumBossMonsterHp = maximumBossMonsterHp;
        this.currentBossMonsterHp = currentBossMonsterHp;
    }

    public int getMaximumBossMonsterHp() {
        return maximumBossMonsterHp;
    }

    public int getCurrentBossMonsterHp() {
        return currentBossMonsterHp;
    }

    public static BossMonsterInfo of(
            final int maximumBossMonsterHp,
            final int currentBossMonsterHp
    ) {
        return new BossMonsterInfo(
                maximumBossMonsterHp,
                currentBossMonsterHp
        );
    }
}
