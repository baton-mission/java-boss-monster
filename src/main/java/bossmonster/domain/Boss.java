package bossmonster.domain;

public class Boss {

    private final BossHp bossHp;

    private Boss(BossHp bossHp) {
        this.bossHp = bossHp;
    }

    private Boss(int bossHp) {
        this(BossHp.from(bossHp));
    }

    public static Boss from(int bossHp) {
        return new Boss(bossHp);
    }

    public int getBossHp() {
        return bossHp.getBossHp();
    }

    public int getInitialBossHp() {
        return bossHp.getInitialBossHp();
    }
}
