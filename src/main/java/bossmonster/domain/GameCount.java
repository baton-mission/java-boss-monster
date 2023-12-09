package bossmonster.domain;

public class GameCount {
    public static final int INIT_GAME_COUNT = 0;
    private int gameCount;

    private GameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public static GameCount init() {
        return new GameCount(INIT_GAME_COUNT);
    }

    public void increase() {
        gameCount++;
    }

    public int getGameCount() {
        return gameCount;
    }
}
