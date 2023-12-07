package bossmonster.domain;

public class Mp {
    private int mp;

    public Mp(int mp) {
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    public void affectMpBy(PlayerAttack playerAttack) {
        mp = playerAttack.applyMp(mp);
    }
}
