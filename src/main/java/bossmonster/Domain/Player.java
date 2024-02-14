package bossmonster.Domain;

public class Player {
    private final int hp;
    private final int mp;
    private String name;

    public Player(int hp, int mp, String name) {
        this.hp = hp;
        this.mp = mp;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public String getName() {
        return name;
    }

}
