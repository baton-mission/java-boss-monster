package bossmonster.service;

public class BossWeapon {

    private static final int MIN_BOSS_DAMAGE = 0;
    private static final int MAX_BOSS_DAMAGE = 20;

    public static int attack() {
        return (int) (Math.random() * MAX_BOSS_DAMAGE - MIN_BOSS_DAMAGE + 1) + MIN_BOSS_DAMAGE;
    }
}
