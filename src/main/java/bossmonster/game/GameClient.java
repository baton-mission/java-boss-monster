package bossmonster.game;

import bossmonster.controller.GamePlayController;
import bossmonster.game.constant.GameStatus;

import static bossmonster.game.constant.GameStatus.*;

public class GameClient {
    private final GamePlayController playController;
    private GameStatus gameStatus;
    private int gameTurn;

    public GameClient(GamePlayController playController) {
        this.playController = playController;
        this.gameStatus = BEFORE_STARTING;
        this.gameTurn = 0;
    }

    public void run() {
        gameStatus = RUNNING;
        playController.displayGameStart();

        while (gameStatus == RUNNING) {
            playTurn();
        }
    }

    private void playTurn() {
        gameTurn += 1;

        playController.playerAttack();
        if (playController.isGameNotContinuable()) {
            playController.playerWin(gameTurn);
            gameStatus = END;
            return;
        }

        playController.bossMonsterAttack();
        if (playController.isGameNotContinuable()) {
            playController.bossMonsterWin();
            gameStatus = END;
            return;
        }

        playController.displayCharacterStatus();
    }
}
