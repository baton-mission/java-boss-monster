package bossmonster.model;

public class Player {
    private final int maxHP;
    private final int maxMP;
    private int HP;
    private int MP;
    private final String name;
    private int attackNumber;

    Player(int maxHP, int maxMP, String name) {
        this.maxHP = maxHP;
        this.maxMP = maxHP;
        this.name = name;
        attackNumber = 0;
    }
    public int getMaxHP() {
        return maxHP;
    }

    public int getHP() {
        return HP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getMP() {
        return MP;
    }

    public String getName() {
        return name;
    }

    public int getAttackNumber() {
        return attackNumber;
    }

    public void addAttackNumber() {
        attackNumber++;
    }
}