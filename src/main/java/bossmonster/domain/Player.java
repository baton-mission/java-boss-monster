package bossmonster.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    String name;
    int hp;
    int mp;

    public Player(String name, List<Integer> status) {
        this.name = name;
        this.hp = status.get(0);
        this.mp = status.get(1);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getStatus() {
        List<Integer> status = new ArrayList<>();
        status.add(hp);
        status.add(mp);
        return status;
    }

    public void getMp() {
        if (mp < 100) {
            mp += 10;
        }
    }

    public void consumeMp() {
        mp -= 30;
    }

    public void reduceHp(int damage) {
        hp -= damage;
    }
}
