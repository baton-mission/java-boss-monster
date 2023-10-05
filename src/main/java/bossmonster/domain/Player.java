package bossmonster.domain;

import bossmonster.AttackType;

public class Player{
    private final String name;
    private final int maxHp;
    private final int maxMp;
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
        return this.currentHp <= 0;
    }
}
