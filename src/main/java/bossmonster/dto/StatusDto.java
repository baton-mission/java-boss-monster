package bossmonster.dto;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class StatusDto {

    int bossHp;
    int bossMaxHp;
    int playerHp;
    int playerMaxHp;
    int playerMp;
    int playerMaxMp;

    public StatusDto(BossMonster bossMonster, Player player) {
        this.bossHp = bossMonster.getHp();
        this.bossMaxHp = bossMonster.getMaxHp();
        this.playerHp = player.getHp();
        this.playerMaxHp = player.getMaxHp();
        this.playerMp = player.getMp();
        this.playerMaxMp = player.getMaxMp();
    }

    public int getBossHp() {
        return bossHp;
    }

    public int getBossMaxHp() {
        return bossMaxHp;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public int getPlayerMaxHp() {
        return playerMaxHp;
    }

    public int getPlayerMp() {
        return playerMp;
    }

    public int getPlayerMaxMp() {
        return playerMaxMp;
    }
}
