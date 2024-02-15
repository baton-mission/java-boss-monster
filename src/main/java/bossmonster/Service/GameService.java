package bossmonster.Service;

import bossmonster.Controller.GameController;
import bossmonster.Domain.Boss;
import bossmonster.Domain.Game;
import bossmonster.Domain.Player;
import bossmonster.Dto.AttackResult;
import bossmonster.Exception.GlobalExceptionHandler;
import java.util.Scanner;

public class GameService {
    private Game game;
    private final GameController gameController;
    private final GlobalExceptionHandler exceptionHandler;

    public GameService(Scanner scanner, GlobalExceptionHandler exceptionHandler) {
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

    public void run() {
        BossService bossService = new BossService(new Scanner(System.in), exceptionHandler);
        PlayerService playerService = new PlayerService(new Scanner(System.in), exceptionHandler);

        Boss boss = bossService.getBoss();
        Player player = playerService.getPlayer();
        game = new Game(0, boss, player);

        gameController.printStartMessage();

        while (true) {
            game.increaseTurn();
            gameController.printBossPlayerStatus(game);
            int attackType = getAttackType();
            if (attackType == 1) {
                AttackResult result = playerService.doPhysicalAttack(game.getPlayer(), game.getBoss());
                game = new Game(game.getTurn(), result.getBoss(), result.getPlayer());
            } else if(game.getPlayer().getMp()>=30) {
                AttackResult result = playerService.doMagicalAttack(game.getPlayer(), game.getBoss());
                game = new Game(game.getTurn(), result.getBoss(), result.getPlayer());
            } else {
                game = exceptionHandler.handleLowMpException(
                        new IllegalArgumentException("[ERROR] MP가 부족합니다. 물리 공격으로 전환되었습니다."), playerService, game);
            }

            if (game.getBoss().getHp() > 0) {
                Player playerAfterAttack = PlayerService.getAttack(game.getPlayer());
                game = new Game(game.getTurn(), game.getBoss(), playerAfterAttack);
            }

            if (game.getBoss().getHp() <= 0) {
                gameController.printSuccessMessage(game);
                break;
            } else if (game.getPlayer().getHp() <= 0) {
                gameController.printFailMessage(game);
                break;
            }
        }
    }
}
