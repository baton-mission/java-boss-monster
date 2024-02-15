package bossmonster.Domain;

public class Boss {
    private final int maxHp;
    private int hp;

    public Boss(int maxHp) {
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public Boss(int maxHp, int hp) {
        this.maxHp = maxHp;
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

}
