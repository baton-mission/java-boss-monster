package bossmonster.domain;

import bossmonster.exception.GameEndException;
import bossmonster.exception.GamePolicyException;

abstract class Player {
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


    abstract void attack(Boss boss, int value);

    abstract void magicAttack(Boss boss, int value);

    void recoveryMp(int value){
        mp = mp + value;
        if(mp > maxMp){
            mp = maxMp;
        }
    }

    protected void useMp(int value){
        mp = mp - value;
    }

    final boolean canUseMp(int value){
        return mp >= value;
    }

    void hit(int value) {
        if (hp - value <= 0 || hp == 0){
            hp = 0;
            throw new GameEndException("플레이어가 죽었습니다!", false);
        }
        hp = hp - value;
    }

    @Override
    public final String toString() {
        return String.format("%s HP [%d/%d]",name, hp, maxHp);
    }

    String getName() {
        return name;
    }
}
