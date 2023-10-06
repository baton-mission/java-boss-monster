package bossmonster.domain;

import java.util.Arrays;

public enum GameStatus {

    RUN,
    STOP;

    public boolean isRunning() {
        return this == RUN;
    }


   /* public static boolean isRun(GameStatus gameStatus) {
        return Arrays.stream(GameStatus.values())
                .filter(status -> status.equals(gameStatus))
                .findAny()
                .orElse(STOP)
                .isRun();
    }*/

}
