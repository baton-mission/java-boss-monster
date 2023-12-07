package bossmonster.controller;

import bossmonster.domain.GameCharacters;
import bossmonster.domain.Monster;
import bossmonster.domain.Player;
import bossmonster.domain.PlayerName;
import bossmonster.domain.PlayerVital;
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
        Player player = Player.of(playerName, playerVital);
        GameCharacters gameCharacters = GameCharacters.of(monster, player);
        outputView.printCharactersInitVital(gameCharacters);

        PlayerAttack playerAttack = inputView.inputPlayerAttack();
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
