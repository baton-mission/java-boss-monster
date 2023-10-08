package bossmonster.exception;

public class GameEndException extends RuntimeException{
    public GameEndException(String msg) {
        super(msg);
    }
}
