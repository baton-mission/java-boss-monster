package bossmonster.domain;

import bossmonster.util.ErrorChecker;

public class Status {

    private final int initialHp;
    private int hp;
    private final int initialMp;
    private int mp;

    public Status(int[] status) {
        ErrorChecker.checkSum(status);
        int hp = status[0];
        int mp = status[1];
        this.initialHp = hp;
        this.initialMp = mp;
        this.hp = hp;
        this.mp = mp;
    }

    public void updateHp(int bossDamage) {
        this.hp -= bossDamage;
    }

    public boolean upperZero() {
        return hp > 0;
    }

    public boolean underZero() {
        return hp <= 0;
    }

    public void updateMana(AttackType type) {
        ErrorChecker.checkMana(this, type.getManaCost());
        this.mp += type.getManaCost();
        if (this.mp > initialMp) {
            this.mp = initialMp;
        }
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getHp() {
        return hp;
    }

    public int getInitialMp() {
        return initialMp;
    }

    public int getMp() {
        return mp;
    }
}
