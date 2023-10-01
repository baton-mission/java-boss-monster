package bossmonster.domain;

import bossmonster.AttackType;

public class Player{
    private String name;
    private int maxHp;
    private int maxMp;
    private int currentHp, currentMp;
    private static final int SUM_OF_HP_MP = 200;
    private static final int MAX_NAME_SIZE = 5;

    public Player(String name, int hp, int mp){
        this.name = name;
        this.maxHp = hp;
        this.currentHp = hp;
        this.maxMp = mp;
        this.currentMp = mp;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public int getCurrentMp() {
        return this.currentMp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int getMaxMp() {
        return this.maxMp;
    }

    public String getName(){
        return this.name;
    }
}
