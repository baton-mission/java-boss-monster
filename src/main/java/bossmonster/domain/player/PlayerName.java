package bossmonster.domain.player;

public class PlayerName {
    public static final int MAX_PLAYER_NAME_LENGTH = 5;
    private final String playerName;

    public PlayerName(String playerName) {
        validateLength(playerName);
        this.playerName = playerName;
    }

    private void validateLength(String playerName) {
        if (!isValidLength(playerName)) {
            throw new IllegalArgumentException(String.format("플레이어 이름은 %d자 이하여야 합니다.", MAX_PLAYER_NAME_LENGTH));
        }
    }

    private boolean isValidLength(String playerName) {
        return playerName.length() <= MAX_PLAYER_NAME_LENGTH;
    }

    public String getPlayerName() {
        return playerName;
    }
}
