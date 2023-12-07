package bossmonster.controller;

import bossmonster.domain.Monster;
import bossmonster.domain.PlayerName;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import java.util.function.Supplier;

public class BossMonsterController {
    private final InputView inputView;
    private final OutputView outputView;

    public BossMonsterController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Monster monster = inputView.inputMonsterHP();
        PlayerName playerName = inputView.inputPlayerName();
        PlayerVital playerVital = inputView.inputPlayerVital();
    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(supplier);
        }
    }
}
