package bossmonster.domain;

import bossmonster.util.ErrorChecker;

import static bossmonster.util.Constants.*;

public class Boss {

    private int hp;
    private final int initialHp;

    public Boss(String input) {
        int hp = ErrorChecker.changeToInt(input);
        ErrorChecker.checkBossHp(hp);
        this.hp = hp;
        this.initialHp = hp;
    }

    public boolean isAlive() {
        return this.hp > ZERO;
    }

    public boolean isDie() {
        return this.hp <= ZERO;
    }

    public int getHp() {
        return hp;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public void getDamage(int damage) {
        this.hp -= damage;
    }
}
