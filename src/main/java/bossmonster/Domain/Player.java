package bossmonster.Domain;

public class Player {
    private final int maxHp;
    private final int maxMp;
    private final String name;

    public Player(int maxHp, int maxMp, String name) {
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public String getName() {
        return name;
    }

}
