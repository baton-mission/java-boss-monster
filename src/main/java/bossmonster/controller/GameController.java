package bossmonster.controller;

import bossmonster.domain.Boss;
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
    }

    private Boss getBossHP() {
        return inputView.getBossHP();
    }
}
