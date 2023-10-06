package bossmonster.dto;

import bossmonster.domain.Player;

public class PlayerDto {
    private final String name;
    private final int hp;
    private final int mp;

    public PlayerDto(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    public PlayerDto(int hp, int mp) {
        this.name = "";
        this.hp = hp;
        this.mp = mp;
    }

    public String getName() {
        return this.name;
    }
    public int getHp() {
        return this.hp;
    }

    public int getMp() {
        return this.mp;
    }

    public static PlayerDto from(Player player) {
        return new PlayerDto(player.getName(), player.getCurrentHp(), player.getCurrentMp());
    }
}
