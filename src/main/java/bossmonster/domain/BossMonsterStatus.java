package bossmonster.domain;

public class BossMonsterStatus {

    private boolean alive;
    private int maxHP;
    private int currentHP;

    public BossMonsterStatus(int maxHP) {
        this.alive = true;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = Math.min(maxHP, currentHP);
        if (currentHP < 0) {
            this.currentHP = 0;
        }
        setAlive(currentHP > 0);
    }

    private void setAlive(boolean status) {
        alive = status;
    }
}
