package bossmonster.domain;

public class Player {

    private final String name;
    private final int hp;
    private final int mp;

    public Player(String name, int hp, int mp){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.hp;
    }

    public int getMp(){
        return this.mp;
    }
}
