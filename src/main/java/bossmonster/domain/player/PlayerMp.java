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

    public boolean hasEnoughMpForAttack(int enoughMp) {
        if (enoughMp <= currentMp) {
            return true;
        }
        return false;
    }

    public void increaseCurrentMp(int increaseMp) {
        currentMp += increaseMp;
        if (currentMp > maximumMp) {
            currentMp = maximumMp;
        }
    }

    public void decreaseCurrentMp(int decreaseMp) {
        currentMp -= decreaseMp;
    }
}
