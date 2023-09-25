package bossmonster.domain;

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
}
