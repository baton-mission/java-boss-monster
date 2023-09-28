package bossmonster;

public class Stat {

    private Hp hp;
    private Mp mp;

    public Stat(Hp hp, Mp mp) {
        this.hp = hp;
        this.mp = mp;
    }

    public boolean isNotSumOfInitialHpAndMp(int sumOfInitialHpAndMp) {
        return !(getSumOfHpAndMp() == sumOfInitialHpAndMp);
    }

    private int getSumOfHpAndMp() {
        return hp.getHp() + mp.getMp();
    }
}
