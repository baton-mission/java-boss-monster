package bossmonster.controller;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.domain.RaidGame;
import bossmonster.domain.dto.GameHistoryDto;
import bossmonster.exception.ExceptionHandler;
import bossmonster.exception.Validator;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.constants.Message;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class Controller {

    public void startGame() {
        RaidGame raidGame = createRaid();
        OutputView.printMessage(Message.OUTPUT_START_RAID);

        while (isGamePossible(raidGame)) {
            showGameStatus(raidGame);
            raidGame.executeTurn(selectAttackType());
            showTurnResult(raidGame);
        }
        showGameOver(raidGame);
    }

    private RaidGame createRaid() {
        OutputView.printMessage(Message.INPUT_MONSTER_HP);
        BossMonster bossMonster = ExceptionHandler.retryInput(this::createBossMonster);

        OutputView.printMessage(Message.INPUT_PLAYER_NAME);
        String playerName = ExceptionHandler.retryInput(this::requestPlayerName);

        OutputView.printMessage(Message.INPUT_PLAYER_HP_MP);
        Player player = ExceptionHandler.retryInput(() -> createPlayer(playerName));

        return new RaidGame(bossMonster, player);
    }

    private BossMonster createBossMonster() {
        int bossMonsterHP = Integer.parseInt(Validator.validateInputOfNumber(InputView.readLine()));
        return new BossMonster(bossMonsterHP);
    }

    private String requestPlayerName() {
        return Validator.validatePlayerName(InputView.readLine());
    }

    private Player createPlayer(String playerName) {
        String[] playerStatus = Validator.validateInputOfNumbers(InputView.readLine());
        int playerHP = Integer.parseInt(playerStatus[0]);
        int playerMP = Integer.parseInt(playerStatus[1]);
        return new Player(playerName, playerHP, playerMP);
    }

    private boolean isGamePossible(RaidGame raidGame) {
        return raidGame.getGameHistory().isGameStatus();
    }

    private void showGameStatus(RaidGame raidGame) {
        OutputView.printGameStatus(raidGame.getGameHistory());
    }

    private AttackType selectAttackType() {
        OutputView.printAttackType(provideAttackType());
        return ExceptionHandler.retryInput(this::requestAttackType);
    }

    private LinkedHashMap<Integer, String> provideAttackType() {
        LinkedHashMap<Integer, String> attackType = new LinkedHashMap<>();
        for (AttackType type : AttackType.values()) {
            if (type.getNumber() != 0) {
                attackType.put(type.getNumber(), type.getName());
            }
        }
        return attackType;
    }

    private AttackType requestAttackType() {
        int valueInput = Integer.parseInt(Validator.validateInputOfNumber(InputView.readLine()));
        return Arrays.stream(AttackType.values())
                .filter(type -> type.getNumber() == valueInput && type.getNumber() != 0)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private void showTurnResult(RaidGame raidGame) {
        OutputView.printTurnResult(raidGame.getGameHistory());
    }

    private void showGameOver(RaidGame raidGame) {
        GameHistoryDto gameHistoryDto = raidGame.getGameHistory();
        if (gameHistoryDto.getMonsterCurrentHP() == 0) {
            OutputView.printPlayerWin(gameHistoryDto);
        }
        if (gameHistoryDto.getPlayerCurrentHP() == 0) {
            OutputView.printGameStatus(gameHistoryDto);
            OutputView.printPlayerLose(gameHistoryDto);
        }
    }
}
