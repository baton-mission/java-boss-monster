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
}
