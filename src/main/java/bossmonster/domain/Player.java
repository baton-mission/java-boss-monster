package bossmonster.domain;

public class Player {

    private final PlayerName playerName;

    private final PlayerStatus playerStatus;

    private Player(PlayerName playerName, PlayerStatus playerStatus) {
        this.playerName = playerName;
        this.playerStatus = playerStatus;
    }

    public static Player from(PlayerName playerName, PlayerStatus playerStatus) {
        return new Player(playerName, playerStatus);
    }
}
