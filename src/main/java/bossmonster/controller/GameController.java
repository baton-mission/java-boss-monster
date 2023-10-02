package bossmonster.controller;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Boss boss = getBossHP();
        Player player = getPlayerInfo();
        outputView.printSetting(boss, player);

        while (boss.isAlive() && player.isAlive()) {
            playTurnOfPlayer();
        }
    }

    private Boss getBossHP() {
        return inputView.getBossHP();
    }

    private Player getPlayerInfo() {
        String name = inputView.getPlayerName();
        int[] playerStatus = inputView.getPlayerStatus();
        return new Player(name, playerStatus[0], playerStatus[1]);
    }

    private void playTurnOfPlayer() {

    }
}
