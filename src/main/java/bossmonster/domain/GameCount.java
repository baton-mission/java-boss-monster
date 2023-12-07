package bossmonster.domain;

public class GameCount {
    private int gameCount;

    public GameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public static GameCount init() {
        return new GameCount(0);
    }

    public void increase() {
        gameCount++;
    }
}
