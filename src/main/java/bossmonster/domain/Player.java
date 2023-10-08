package bossmonster.domain;

import bossmonster.exception.GameEndException;

class Player {
    protected final String name;
    private int hp;
    private int mp;
    private final int maxHp;
    private final int maxMp;


    Player(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        maxHp = hp;
        maxMp = mp;
    }


    void attack(Boss boss, int damageValue) {
        recoveryMp(10);
        boss.hit(damageValue);
    }

    void magicAttack(Boss boss, int damageValue){
        useMp(30);
        boss.hit(damageValue);
    }

    void recoveryMp(int recoveryValue){
        mp = mp + recoveryValue;
        if(mp > maxMp){
            mp = maxMp;
        }
    }

    protected void useMp(int useValue){
        mp = mp - useValue;
    }

    final boolean canUseMp(int useRequestValue){
        return mp >= useRequestValue;
    }

    void hit(int damageValue) {
        if (hp - damageValue <= 0 || hp == 0){
            hp = 0;
            throw new GameEndException("플레이어가 죽었습니다!", false);
        }
        hp = hp - damageValue;
    }

    @Override
    public final String toString() {
        return String.format("%s HP [%d/%d] MP [%d/%d]",name, hp, maxHp, mp, maxMp);
    }

    String getName() {
        return name;
    }
}
