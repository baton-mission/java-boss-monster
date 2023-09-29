package bossmonster.domain.player;

import static bossmonster.domain.player.constant.PlayerOption.PLAYER_NAME_MAXIMUM_LENGTH_LIMIT;

public class PlayerName {
    private final String playerName;

    public PlayerName(String playerName) {
        validatePlayerName(playerName);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    private void validatePlayerName(String playerName) {
        if (playerName.isBlank() || playerName.length() > PLAYER_NAME_MAXIMUM_LENGTH_LIMIT) {
            throw new IllegalArgumentException("유효하지 않은 플레이어 이름입니다.");
        }
    }
}
