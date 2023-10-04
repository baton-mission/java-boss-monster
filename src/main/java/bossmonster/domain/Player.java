package bossmonster.domain;

import bossmonster.exception.GameEndException;
import bossmonster.exception.GamePolicyException;

public abstract class Player {
    protected final String name;
    protected int hp;
    protected int mp;
    protected final int maxHp;
    protected final int maxMp;


    public Player(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        maxHp = hp;
        maxMp = mp;
    }


    public abstract void attack(Boss boss, int value);

    public abstract void magicAttack(Boss boss, int value);

    protected void recoveryMp(int value){
        mp = mp + value;
    }

    protected void useMp(int value){
        mp = mp - value;
    }

    public final boolean canUseMp(int value){
        return mp >= value;
    }

    public void hit(int value) {
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

    public String getName() {
        return name;
    }
}
