package bossmonster.domain;

public final class CurrentBossHp {

    private static final int BOSS_ZERO_HP = 0;
    private final int currentBossHp;

    private CurrentBossHp(int currentBossHp) {
        this.currentBossHp = currentBossHp;
    }

    public static CurrentBossHp from(int currentBossHp) {
        return new CurrentBossHp(currentBossHp);
    }

    public int getCurrentBossHp() {
        return currentBossHp;
    }

    public CurrentBossHp attackedBy(AttackType attackType) {
        int bossHpFromAttack = attackType.attack(currentBossHp);
        int currentBossHp = setBossHpNotToUnderMin(bossHpFromAttack);
        return new CurrentBossHp(currentBossHp);
    }

    private int setBossHpNotToUnderMin(int bossHpFromAttack) {
        return Math.max(BOSS_ZERO_HP, bossHpFromAttack);
    }

    public boolean isUnderZero() {
        return currentBossHp <= BOSS_ZERO_HP;
    }
}
