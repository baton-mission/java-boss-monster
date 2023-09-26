package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE;

public class PlayerName {

    private static final int MAX_NAME_LENGTH = 5;
    private final String playerName;

    private PlayerName(String playerName) {
        validate(playerName);
        this.playerName = playerName;
    }

    private void validate(String playerName) {
        validateSize(playerName);
    }

    private void validateSize(String playerName) {
        if (!isRightSize(playerName)) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private boolean isRightSize(String playerName) {
        return playerName.length() <= MAX_NAME_LENGTH;
    }

    public static PlayerName from(String playerName) {
        return new PlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }
}
