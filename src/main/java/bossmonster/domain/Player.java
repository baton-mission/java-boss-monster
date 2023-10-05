package bossmonster.domain;

import bossmonster.AttackType;

public class Player{
    private String name;
    private int maxHp;
    private int maxMp;
    private int currentHp, currentMp;

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
    
    public static int[] validatesumOfHpMp(int hp, int mp) {
        if(hp + mp != SUM_OF_HP_MP){
            throw new IllegalArgumentException("[Error] Sum of Hp and Mp should be 200");
        }
        int[] hpMp = {hp, mp};
        return hpMp;
    }

    public int attack(AttackType attacktype) {
        if(this.currentMp - attacktype.getmpNeeded() < 0) {
            throw new IllegalArgumentException("Not enough Mana");
        }
        this.currentMp -= attacktype.getmpNeeded();
        this.currentMp = Math.min(currentMp + attacktype.getReGenMp(), maxMp);

        return attacktype.getDamage();
    }

    public void attacked(int bossDamage) {
        this.currentHp -= bossDamage;
    }

    public boolean isDead(){
        if(this.currentHp <= 0) return true;
        return false;
    }
}
