package bossmonster.domain.player;

public class PlayerHp {

    private int currentHp;
    private final int maxHp;

    public PlayerHp(int hp) {
        this.currentHp = hp;
        this.maxHp = hp;
    }

    public void reduceHp(int damage) {
        this.currentHp -= damage;
        if (this.currentHp < 0) {
            this.currentHp = 0;
        }
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public boolean hasHPGreaterThanZero() {
        return currentHp > 0;
    }
}
