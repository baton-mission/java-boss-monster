package bossmonster.Service;

import bossmonster.Controller.GameController;
import bossmonster.Domain.Game;
import bossmonster.Exception.GlobalExceptionHandler;
import java.util.Scanner;

public class GameService {
    private final Game game;
    private final GameController gameController;
    private final GlobalExceptionHandler exceptionHandler;

    public GameService(Scanner scanner, GlobalExceptionHandler exceptionHandler, Game game) {
        this.game = game;
        this.gameController = new GameController(scanner);
        this.exceptionHandler = exceptionHandler;
    }

    public int getAttackType() {
        int attackType = gameController.getAttackType();
        if (attackType != 1 && attackType != 2) {
            return exceptionHandler.handleIllegalAttackTypeException(
                    new IllegalArgumentException("[ERROR] 공격 타입은 1 또는 2여야 합니다."), this);
        }
        return attackType;
    }
}
