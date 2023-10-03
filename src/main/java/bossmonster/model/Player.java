package bossmonster.model;

public class Player {
    private final int maxHP;
    private final int maxMP;
    private int HP;
    private int MP;
    private final String name;
    private int attackNumber;

    public Player(int maxHP, int maxMP, String name) {
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.HP = maxHP;
        this.MP = maxMP;
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

    public void subtractHP(int damage) {
        HP -= damage;
    }

    public void subtractMP() {
        MP -= 30;
    }

    public void addMP() {
        MP += 10;
    }

    public void modifyHP() {
        HP = 0;
    }

    public void modifyMP() {MP = maxMP;}
    public int getAttackNumber() {
        return attackNumber;
    }

    public void addAttackNumber() {
        attackNumber++;
    }
}