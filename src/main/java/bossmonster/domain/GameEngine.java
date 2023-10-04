package bossmonster.domain;

public interface GameEngine {
    void initGame();
    void startGame();
    void playerTurn();
    void bossTurn();
    void endGame();
}
