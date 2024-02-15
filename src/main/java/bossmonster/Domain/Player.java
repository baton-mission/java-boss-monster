package bossmonster.Domain;

public class Player {
    private final int maxHp;
    private final int maxMp;
    private final int hp;
    private final int mp;
    private final String name;

    public Player(int maxHp, int maxMp, String name) {
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.hp = maxHp;
        this.mp = maxMp;
        this.name = name;
    }

    public Player(int maxHp, int maxMp, int hp, int mp, String name) {
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.hp = hp;
        this.mp = mp;
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getHp() { return hp; }

    public int getMp() { return mp; }

    public String getName() {
        return name;
    }

}
