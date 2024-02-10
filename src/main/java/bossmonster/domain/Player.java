package bossmonster.domain;

import bossmonster.exception.NoMPException;

public class Player {
    private final String name;
    private final Integer maxHp;
    private Integer currentHp;
    private final Integer maxMp;
    private Integer currentMp;

    public Player(String name, Integer hp, Integer mp) {
        this.name = name;
        this.maxHp = hp;
        this.currentHp = hp;
        this.maxMp = mp;
        this.currentMp = mp;
        printStat();
    }

    public String getName() { return name; }

    public Integer getHp() { return currentHp; }

    public void printStat() {
        System.out.println(this.name + " HP [" + this.currentHp + "/" + this.maxHp + "]"
                + " MP [" + this.currentMp + "/" + this.maxMp + "]");
        System.out.println("======================================\n");
    }

    public void decreaseHp(final Integer hp) {
        if(this.currentHp - hp < 0) {
            this.currentHp = 0;
            return;
        }

        this.currentHp -= hp;
    }

    public Integer physicalAttack() {
        if(this.currentMp + 10 > this.maxMp)
            this.currentMp = this.maxMp;
        else this.currentMp += 10;

        return 10;
    }

    public Integer magicalAttack() throws NoMPException {
        if(currentMp < 30)
            throw new NoMPException();

        this.currentMp -= 30;
        return 20;
    }
}