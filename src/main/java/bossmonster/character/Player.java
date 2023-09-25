package bossmonster.character;

public class Player {
    private int HP;

    private int MP;

    private int currentHP;

    private int currentMP;

    private String name;

    public Player() {
    }

    // 200 = HP + MP
    public Player(int HP, int MP, String name) {
        this.HP = HP;
        this.MP = MP;
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }
}