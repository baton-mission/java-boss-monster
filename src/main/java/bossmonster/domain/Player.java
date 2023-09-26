package bossmonster.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    String name;
    int hp;
    int mp;
    int maxHp;
    int maxMp;

    public Player(String name, List<Integer> status) {
        this.name = name;
        this.hp = status.get(0);
        this.maxHp = status.get(0);
        this.mp = status.get(1);
        this.maxMp = status.get(1);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void gainMp() {
        if (mp < maxMp) {
            mp += 10;
        }
    }

    public void consumeMp() {
        mp -= 30;
    }

    public void reduceHp(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }
}
