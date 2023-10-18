package bossmonster.domain.player;

public class PlayerName {

    public static final int PLAYER_NAME_MIN_LENGTH = 0;
    public static final int PLAYER_NAME_MAX_LENGTH = 5;
    private final String name;

    public PlayerName(String name) {
        validateSize(name);
        this.name = name;
    }

    private void validateSize(String name) {
        if (name.length() > PLAYER_NAME_MAX_LENGTH || name.length() <= PLAYER_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("사용자의 닉네임은 5글자 이하여야합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
