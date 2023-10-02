package bossmonster.controller;

import bossmonster.domain.AttackType;
import bossmonster.domain.Boss;
import bossmonster.domain.GameStatus;
import bossmonster.domain.Player;
import bossmonster.service.BossWeapon;
import bossmonster.service.GameService;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = new GameService();
    }

    public void run() {
        Boss boss = getBossInfo();
        Player player = getPlayerInfo();
        outputView.printSetting(boss, player);
        GameStatus status = new GameStatus();
        while (boss.isAlive() && player.isAlive()) {
            AttackType type = playTurnOfPlayer(boss, player);
            if (boss.isDie()) {
                outputView.printBossDie(player, status);
                break;
            }
            int bossDamage = playTurnOfBoss(player);
            if (player.isDie()) {
                outputView.printPlayerDie(player);
                break;
            }
            status.updateInfo(type, bossDamage);
            outputView.printResult(boss, player, status);
            status.nextRound();
        }
    }

    private Boss getBossInfo() {
        return inputView.getBossHP();
    }

    private Player getPlayerInfo() {
        String name = inputView.getPlayerName();
        int[] playerStatus = inputView.getPlayerStatus();
        return new Player(name, playerStatus[0], playerStatus[1]);
    }

    private AttackType playTurnOfPlayer(Boss boss, Player player) {
        AttackType type = inputView.getAttackType();
        gameService.attackToBoss(boss, type);
        player.updateMana(type);
        return type;
    }

    private int playTurnOfBoss(Player player) {
        int bossDamage = BossWeapon.attack();
        gameService.attackToPlayer(player, bossDamage);
        return bossDamage;
    }
}
