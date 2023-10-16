package bossmonster.domain.player;

public class PlayerMp {

    private int currentMp;

    private final int maxMp;

    public PlayerMp(int mp) {
        this.currentMp = mp;
        this.maxMp = mp;
    }

    public void changeMp(Skill skill) {
        this.currentMp = this.currentMp - skill.getMp();
        if (this.currentMp > maxMp) {
            this.currentMp = maxMp;
        }
    }

    public boolean isInsufficientMp(Skill skill) {
        return this.currentMp < skill.getMp();
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public int getMaxMp() {
        return maxMp;
    }


}
