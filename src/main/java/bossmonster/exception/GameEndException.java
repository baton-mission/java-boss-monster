package bossmonster.exception;

public class GameEndException extends RuntimeException{
    private final boolean playerWin;
    public GameEndException(Throwable cause, boolean isPlayerWin) {
        super(cause);
        this.playerWin = isPlayerWin;
    }

    public boolean isPlayerWin() {
        return playerWin;
    }
}
