package bossmonster.domain.player;

import bossmonster.domain.Hp;
import bossmonster.domain.PlayerAttack;

public class Player {
    private final PlayerName playerName;
    private final PlayerVital playerVital;

    private Player(PlayerName playerName, PlayerVital playerVital) {
        this.playerName = playerName;
        this.playerVital = playerVital;
    }

    public static Player of(PlayerName playerName, PlayerVital playerVital) {
        return new Player(playerName, playerVital);
    }

    public void damagedBy(Hp monsterAttack) {
        playerVital.damagedBy(monsterAttack);
    }

    public void affectMpBy(PlayerAttack playerAttack) {
        playerVital.affectMpBy(playerAttack);
    }

    public boolean isOver() {
        return playerVital.isOver();
    }

    public void validateAttackMp(PlayerAttack playerAttack) {
        playerVital.validateAttackMp(playerAttack);
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public PlayerVital getPlayerVital() {
        return playerVital;
    }
}
