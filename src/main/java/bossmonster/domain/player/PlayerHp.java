package bossmonster.domain.player;

public class PlayerHp {
    private final int maximumHp;
    private int currentHp;

    public PlayerHp(int hp) {
        this.maximumHp = hp;
        this.currentHp = hp;
    }

    public int getMaximumHp() {
        return maximumHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void decreaseCurrentHp(int decreaseHp) {
        currentHp -= decreaseHp;
    }

    public boolean isCurrentHpZeroOrBelow() {
        return currentHp <= 0;
    }
}
