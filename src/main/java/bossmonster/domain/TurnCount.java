package bossmonster.domain;

import static bossmonster.domain.ExceptionMessage.TURN_COUNT_EXCEPTION_MESSAGE;

import java.util.Objects;

public class TurnCount {

    private static final int MIN_TURN_COUNT = 0;

    private final int turnCount;

    private TurnCount(int turnCount) {
        validate(turnCount);
        this.turnCount = turnCount;
    }

    private void validate(int turnCount) {
        validateRange(turnCount);
    }

    private void validateRange(int turnCount) {
        if (isUnderZero(turnCount)) {
            throw new IllegalArgumentException(TURN_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isUnderZero(int turnCount) {
        return turnCount < MIN_TURN_COUNT;
    }

    private TurnCount() {
        this(MIN_TURN_COUNT);
    }

    public static TurnCount init() {
        return new TurnCount();
    }

    public static TurnCount fromTest(int count) {
        return new TurnCount(count);
    }

    public TurnCount increase() {
        return new TurnCount(turnCount + 1);
    }

    public int getTurnCount() {
        return turnCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurnCount turnCount1 = (TurnCount) o;
        return turnCount == turnCount1.turnCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(turnCount);
    }
}
