package bossmonster.domain.player;

public class PlayerMp {
    private final int maximumMp;
    private int currentMp;

    public PlayerMp(int mp) {
        this.maximumMp = mp;
        this.currentMp = mp;
    }

    public int getMaximumMp() {
        return maximumMp;
    }

    public int getCurrentMp() {
        return currentMp;
    }
}
