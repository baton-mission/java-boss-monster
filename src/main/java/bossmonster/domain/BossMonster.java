package bossmonster.domain;

import java.util.Random;

public class BossMonster {
    private static Random rand = new Random();

    private int maxHp;
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

    public static int validateBossHp(int hp) {
        if (hp > MAX_HP_SIZE || hp < MIN_HP_SIZE) {
            throw new IllegalArgumentException(
                    "[Error] Boss monster's health should be in between 100 to 300");
        }
        return hp;
    }

    public int attack() {
        return rand.nextInt(19) + 1;
    }

    public void attacked(int playerDamage) {
        this.currentHp -= playerDamage;
    }

    public boolean isDead() {
        if (currentHp <= 0)
            return true;
        return false;
    }
}
