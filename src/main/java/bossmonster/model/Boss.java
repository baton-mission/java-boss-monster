package bossmonster.model;

public class Boss {
    private int HP;
    private final int maxHP;

    public Boss(int maxHP) {
        this.maxHP = maxHP;
        this.HP = maxHP;
    }

    public int getHP() {
        return HP;
    }

    public void subtractHP(int damage) {
        HP -= damage;
    }

    public int getMaxHP() {
        return maxHP;
    }
}