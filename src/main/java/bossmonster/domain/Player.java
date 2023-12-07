package bossmonster.domain;

public class Player {
    private final PlayerName playerName;
    private final PlayerVital playerVital;

    public Player(PlayerName playerName, PlayerVital playerVital) {
        this.playerName = playerName;
        this.playerVital = playerVital;
    }

    public static Player of(PlayerName playerName, PlayerVital playerVital) {
        return new Player(playerName, playerVital);
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public PlayerVital getPlayerVital() {
        return playerVital;
    }
}
