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
import java.util.function.Function;
import java.util.function.Supplier;

public class MonsterGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final AttackGenerator attackGenerator;

    public MonsterGameController(InputView inputView, OutputView outputView, AttackGenerator attackGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.attackGenerator = attackGenerator;
    }

    public void run() {
        GameCharacters gameCharacters = generateGameCharacters();
        displayInitVital(gameCharacters);

        MonsterGame monsterGame = MonsterGame.init(gameCharacters);
        playGame(monsterGame, gameCharacters);

        displayGameResult(monsterGame, gameCharacters);
    }

    private GameCharacters generateGameCharacters() {
        Monster monster = readWithRetry(inputView::inputMonsterHP);

        PlayerName playerName = readWithRetry(inputView::inputPlayerName);
        PlayerVital playerVital = readWithRetry(inputView::inputPlayerVital);
        Player player = Player.of(playerName, playerVital);

        return GameCharacters.of(monster, player);
    }

    private void displayInitVital(GameCharacters gameCharacters) {
        outputView.printCharactersInitVital(gameCharacters);
    }

    private void playGame(MonsterGame monsterGame, GameCharacters gameCharacters) {
        while (!monsterGame.isAnyCharacterOver()) {
            playRound(monsterGame, gameCharacters);
        }
    }

    private void displayGameResult(MonsterGame monsterGame, GameCharacters gameCharacters) {
        if (monsterGame.isMonsterOver()) {
            outputView.printPlayerWin(monsterGame);
        }
        if (monsterGame.isPlayerOver()) {
            outputView.printPlayerOver(gameCharacters);
        }
    }

    private void playRound(MonsterGame monsterGame, GameCharacters gameCharacters) {
        PlayerAttack playerAttack = readWithRetry(this::getPlayerAttack, gameCharacters);
        Hp monsterAttack = attackGenerator.generate();

        monsterGame.applyPlayerAttack(playerAttack);
        monsterGame.applyMonsterAttack(monsterAttack);

        diplayAttack(monsterGame.isMonsterOver(), playerAttack, monsterAttack);
        displayCharactersVital(monsterGame.isPlayerOver(), gameCharacters);
    }

    private PlayerAttack getPlayerAttack(GameCharacters gameCharacters) {
        PlayerAttack playerAttack = readWithRetry(inputView::inputPlayerAttack);
        gameCharacters.validateAttackMp(playerAttack);
        return playerAttack;
    }

    private void diplayAttack(boolean isMonsterOver, PlayerAttack playerAttack, Hp monsterAttack) {
        if (!isMonsterOver) {
            outputView.printAttack(playerAttack, monsterAttack);
        }
        if (isMonsterOver) {
            outputView.printAttack(playerAttack);
        }
    }

    private void displayCharactersVital(boolean isPlayerOver, GameCharacters gameCharacters) {
        if (isPlayerOver) {
            outputView.printCharactersMonsterWinningVital(gameCharacters);
        }
        if (!isPlayerOver) {
            outputView.printCharactersCurrnetVital(gameCharacters);
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

    private <T, R> R readWithRetry(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(function, input);
        }
    }
}
