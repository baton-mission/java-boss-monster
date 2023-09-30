package bossmonster.dto;

public class PlayerInfo {
    private final String playerName;
    private final int playerMaximumHp;
    private final int playerCurrentHp;
    private final int playerMaximumMp;
    private final int playerCurrentMp;

    public PlayerInfo(
            final String playerName,
            final int playerMaximumHp,
            final int playerCurrentHp,
            final int playerMaximumMp,
            final int playerCurrentMp
    ) {
        this.playerName = playerName;
        this.playerMaximumHp = playerMaximumHp;
        this.playerCurrentHp = playerCurrentHp;
        this.playerMaximumMp = playerMaximumMp;
        this.playerCurrentMp = playerCurrentMp;
    }

    public static PlayerInfo of(
            final String playerName,
            final int playerMaximumHp,
            final int playerCurrentHp,
            final int playerMaximumMp,
            final int playerCurrentMp
    ) {
        return new PlayerInfo(
                playerName,
                playerMaximumHp,
                playerCurrentHp,
                playerMaximumMp,
                playerCurrentMp
        );
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerMaximumHp() {
        return playerMaximumHp;
    }

    public int getPlayerCurrentHp() {
        return playerCurrentHp;
    }

    public int getPlayerMaximumMp() {
        return playerMaximumMp;
    }

    public int getPlayerCurrentMp() {
        return playerCurrentMp;
    }
}
