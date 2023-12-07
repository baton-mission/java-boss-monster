package bossmonster.domain;

public class PlayerName {
    private final String playerName;

    public PlayerName(String playerName) {
        validateLength(playerName);
        this.playerName = playerName;
    }

    private void validateLength(String playerName) {
        if (!isValidLength(playerName)) {
            throw new IllegalArgumentException("플레이어 이름은 5자 이하여야 합니다.");
        }
    }

    private boolean isValidLength(String playerName) {
        return playerName.length() <= 5;
    }
}
