package bossmonster.dto.response;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;

public class BossAndPlayerStatusDto {

    private final int initialBossHp;
    private final int currentBossHp;
    private final String playerName;
    private final int initialPlayerHp;
    private final int initialPlayerMp;
    private final int currentPlayerHp;
    private final int currentPlayerMp;

    public BossAndPlayerStatusDto(Boss boss, Player player) {
        this.initialBossHp = boss.getInitialBossHp();
        this.currentBossHp = boss.getBossHp();
        this.playerName = player.getPlayerName();
        this.initialPlayerHp = player.getInitialPlayerHp();
        this.initialPlayerMp = player.getInitialPlayerMp();
        this.currentPlayerHp = player.getPlayerHp();
        this.currentPlayerMp = player.getPlayerMp();
    }

    public int getInitialBossHp() {
        return initialBossHp;
    }

    public int getCurrentBossHp() {
        return currentBossHp;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getInitialPlayerHp() {
        return initialPlayerHp;
    }

    public int getInitialPlayerMp() {
        return initialPlayerMp;
    }

    public int getCurrentPlayerHp() {
        return currentPlayerHp;
    }

    public int getCurrentPlayerMp() {
        return currentPlayerMp;
    }
}
