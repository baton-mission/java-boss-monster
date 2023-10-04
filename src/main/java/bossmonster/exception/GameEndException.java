package bossmonster.exception;

public class GameEndException extends RuntimeException{
    private final boolean playerWin;
    public GameEndException(String msg, boolean isPlayerWin) {
        super(msg);
        this.playerWin = isPlayerWin;
    }

    public boolean isPlayerWin() {
        return playerWin;
    }
}
