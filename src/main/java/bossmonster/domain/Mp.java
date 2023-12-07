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
        int newMp = playerAttack.applyMp(mp);
        if (isOverMax(newMp)) {
            mp = 200;
        }
        if (!isOverMax(newMp)) {
            mp = newMp;
        }
    }

    private static boolean isOverMax(int newMp) {
        return newMp > 200;
    }
}
