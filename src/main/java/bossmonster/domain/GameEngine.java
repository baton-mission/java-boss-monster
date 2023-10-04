package bossmonster.domain;

import bossmonster.view.InputProcessor;

public interface GameEngine {
    void initGame(InputProcessor inputProcessor);
    void startGame();
    void playerTurn();
    void bossTurn();
    void endGame();
}
