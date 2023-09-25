package bossmonster.character;

public class BossMoster {
    private int HP; // 100 ~ 300

    private int currentHP;

    public BossMoster(int HP) {
        this.HP = HP;
    }

    public BossMoster() {
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
}