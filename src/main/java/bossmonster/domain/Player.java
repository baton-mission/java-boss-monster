package bossmonster.domain;

public class Player {

    private final String name;
    private final int hp;
    private final int mp;
    private final int initHp;
    private final int initMp;

    public Player(String name, int hp, int mp){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.initHp = hp;
        this.initMp = mp;
    }

    public Player(int hp, int mp, Player player){
        this.name = player.getName();
        this.hp = hp;
        this.mp = mp;
        this.initHp = player.getInitHp();
        this.initMp = player.getInitMp();
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

    public int getInitHp(){
        return this.initHp;
    }

    public int getInitMp(){
        return this.initMp;
    }
}
