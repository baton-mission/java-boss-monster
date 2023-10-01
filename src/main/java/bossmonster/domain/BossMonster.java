package bossmonster.domain;

import java.util.Random;

public class BossMonster {
    private static Random rand = new Random();

    private int maxHp;
    private int currentHp;
    private static final int MAX_HP_SIZE = 300;
    private static final int MIN_HP_SIZE = 100;

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
}
