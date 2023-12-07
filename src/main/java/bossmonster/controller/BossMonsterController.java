package bossmonster.controller;

import bossmonster.domain.AttackGenerator;
import bossmonster.domain.GameCharacters;
import bossmonster.domain.Hp;
import bossmonster.domain.Monster;
import bossmonster.domain.MonsterGame;
import bossmonster.domain.Player;
import bossmonster.domain.PlayerAttack;
import bossmonster.domain.PlayerName;
import bossmonster.domain.PlayerVital;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import java.util.function.Supplier;

public class BossMonsterController {
    private final InputView inputView;
    private final OutputView outputView;
    private final AttackGenerator attackGenerator;

    public BossMonsterController(InputView inputView, OutputView outputView, AttackGenerator attackGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.attackGenerator = attackGenerator;
    }

    public void run() {
        Monster monster = readWithRetry(inputView::inputMonsterHP);
        PlayerName playerName = readWithRetry(inputView::inputPlayerName);
        PlayerVital playerVital = readWithRetry(inputView::inputPlayerVital);
        Player player = Player.of(playerName, playerVital);
        GameCharacters gameCharacters = GameCharacters.of(monster, player);
        outputView.printCharactersInitVital(gameCharacters);

        MonsterGame monsterGame = MonsterGame.from(gameCharacters);
        while (!monsterGame.isAnyCharacterOver()) {
            PlayerAttack playerAttack = readWithRetry(inputView::inputPlayerAttack);
            Hp monsterAttack = attackGenerator.generate();

            monsterGame.applyPlayerAttack(playerAttack);

            if (!monsterGame.isMonsterOver()) {
                monsterGame.applyMonsterAttack(monsterAttack);
                outputView.printAttack(playerAttack, monsterAttack);

            }

            if (monsterGame.isMonsterOver()) {
                outputView.printAttack(playerAttack);
            }

            if (monsterGame.isPlayerOver()) {
                outputView.printCharactersMonsterWinningVital(gameCharacters);
            }
            if (!monsterGame.isPlayerOver()) {
                outputView.printCharactersCurrnetVital(gameCharacters);
            }
        }

        if (monsterGame.isMonsterOver()) {
            outputView.printPlayerWin(monsterGame);
        }
        if (monsterGame.isPlayerOver()) {
            outputView.printPlayerOver(playerName);
        }

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
