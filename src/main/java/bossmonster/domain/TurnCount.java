package bossmonster.domain;

public class TurnCount {

    private final int turnCount;

    private TurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    private TurnCount() {
        this(0);
    }

    public static TurnCount init() {
        return new TurnCount();
    }

    public TurnCount increase() {
        return new TurnCount(turnCount + 1);
    }
}
