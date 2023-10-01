package bossmonster.dto;

import java.util.List;

import bossmonster.player.Player;

public class PlayerInfo {

    private String name;
    private int hp;
    private int initialHp;
    private int mp;
    private int initialMp;

    private PlayerInfo(String name, List<Integer> stat) {
        this.name = name;
        this.hp = stat.get(0);
        this.initialHp = stat.get(1);
        this.mp = stat.get(2);
        this.initialMp = stat.get(3);
    }

    public static PlayerInfo from(Player player) {
        return new PlayerInfo(player.name(), player.stat());
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getMp() {
        return mp;
    }

    public int getInitialMp() {
        return initialMp;
    }
}
