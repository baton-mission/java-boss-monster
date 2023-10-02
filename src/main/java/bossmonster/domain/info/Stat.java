package bossmonster.domain.info;

import java.util.List;

import bossmonster.domain.info.Hp;
import bossmonster.domain.info.Mp;

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

    public void consumeMp(int mpConsumption) {
        this.mp.consume(mpConsumption);
    }

    public void reduceByDamage(int damage) {
        hp.reduceByDamage(damage);
    }

    public List<Integer> hpAndInitialHpAndMpAndInitialMp() {
        return List.of(hp.getHp(), hp.getInitialHp(), mp.getMp(), mp.getInitialMp());
    }

    public boolean isHPZeroOrLess() {
        return hp.isZeroOrLess();
    }
}
