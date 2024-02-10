package bossmonster.domain;

public class BossMonster {

    private final int hp;
    private final int initHp;

    public BossMonster(int hp){
        this.hp = hp;
        this.initHp = hp;
    }

    public BossMonster(int hp, int initHp){
        this.hp = hp;
        this.initHp = initHp;
    }

    public int getHp(){
        return this.hp;
    }

    public int getInitHp(){
        return this.initHp;
    }
}
