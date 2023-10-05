package bossmonster.domain;

import java.util.Random;

public class BossMonster {
    private static final Random rand = new Random();

    private final int maxHp;
    private int currentHp;

    public BossMonster(int hp) {
        this.currentHp = hp;
        this.maxHp = hp;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int attack() {
        return rand.nextInt(19) + 1;
    }

    public void attacked(int playerDamage) {
        this.currentHp -= playerDamage;
    }

    public boolean isDead() {
        return currentHp <= 0;
    }
}
