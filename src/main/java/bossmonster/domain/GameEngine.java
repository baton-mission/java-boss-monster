package bossmonster.domain;

import bossmonster.view.InputProcessor;
import bossmonster.view.OutputProcessor;

public interface GameEngine {
    void initGame(InputProcessor inputProcessor);
    void startGame();
    void playerTurn();
    void bossTurn();
    void endGame(OutputProcessor outputProcessor);
}
