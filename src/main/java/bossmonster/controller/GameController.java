package bossmonster.controller;

import bossmonster.domain.*;
import bossmonster.service.BossWeapon;
import bossmonster.service.GameService;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameStatus status;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.status = new GameStatus();
        this.gameService = new GameService(status);
    }

    public void run() {
        Boss boss = getBossInfo();
        Player player = getPlayerInfo();
        outputView.printSetting(boss, player);
        while (boss.isAlive() && player.isAlive()) {
            playTurnOfPlayer(boss, player);
            if (boss.isDie()) break;
            playTurnOfBoss(player);
            if (player.isDie()) break;
            outputView.printResult(boss, player, status);
        }
        checkWhoIsWin(boss, player);
    }

    private Boss getBossInfo() {
        return inputView.getBossHP();
    }

    private Player getPlayerInfo() {
        Name name = inputView.getPlayerName();
        Status status = inputView.getPlayerStatus();
        return new Player(name, status);
    }

    private void playTurnOfPlayer(Boss boss, Player player) {
        AttackType type = inputView.getAttackType(player);
        gameService.attackToBoss(boss, player, type);
    }

    private void playTurnOfBoss(Player player) {
        int bossDamage = BossWeapon.attack();
        gameService.attackToPlayer(bossDamage, player);
    }

    private void checkWhoIsWin(Boss boss, Player player) {
        if (boss.isDie()) {
            outputView.printBossDie(player, status);
        }
        if (player.isDie()) {
            outputView.printPlayerDie(player);
        }
    }
}
