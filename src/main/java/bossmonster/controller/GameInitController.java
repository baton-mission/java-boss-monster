package bossmonster.controller;

import bossmonster.domain.bossmonster.BossMonster;
import bossmonster.domain.bossmonster.BossMonsterHp;
import bossmonster.domain.bossmonster.BossMonsterImpl;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.PlayerHpAndMp;
import bossmonster.domain.player.PlayerImpl;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.scanner.GameInputScanner;
import bossmonster.domain.scanner.GameInputScannerImpl;
import bossmonster.view.ErrorView;
import bossmonster.view.InputView;

import static bossmonster.domain.player.constant.PlayerOption.INPUT_PLAYER_HP_AND_MP_DELIMITER;
import static bossmonster.view.constant.ErrorMessage.*;
import static bossmonster.view.constant.InputMessage.*;

public class GameInitController {
    private final GameInputScanner scanner = new GameInputScannerImpl();
    private final InputView inputView = new InputView();
    private final ErrorView errorView = new ErrorView();

    public BossMonster initBossMonster() {
        BossMonsterHp bossMonsterHp = initBossMonsterHP();
        return new BossMonsterImpl(bossMonsterHp);
    }

    private BossMonsterHp initBossMonsterHP() {
        BossMonsterHp bossMonsterHp;

        do {
            bossMonsterHp = inputBossMonsterHp();
        } while (isBossMonsterHpNotInit(bossMonsterHp));

        return bossMonsterHp;
    }

    private BossMonsterHp inputBossMonsterHp() {
        try {
            inputView.printUserInputMessage(INPUT_BOSS_MONSTER_HP_MESSAGE);
            return new BossMonsterHp(scanner.inputNumber());
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(INVALID_BOSS_MONSTER_HP_INPUT_ERROR_MESSAGE);
            return null;
        }
    }

    private boolean isBossMonsterHpNotInit(BossMonsterHp bossMonsterHp) {
        return bossMonsterHp == null;
    }

    public Player initPlayer() {
        PlayerName playerName = initPlayerName();
        PlayerHpAndMp playerHpAndMp = initPlayerHpAndMp();

        return new PlayerImpl(
                playerName,
                playerHpAndMp.getHp(),
                playerHpAndMp.getMp()
        );
    }

    private PlayerName initPlayerName() {
        PlayerName playerName;

        do {
            playerName = inputPlayerName();
        } while (isPlayerNameNotInit(playerName));

        return playerName;
    }

    private PlayerName inputPlayerName() {
        try {
            inputView.printUserInputMessage(INPUT_PLAYER_NAME_MESSAGE);
            return new PlayerName(scanner.inputString());
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(INVALID_PLAYER_NAME_INPUT_ERROR_MESSAGE);
            return null;
        }
    }

    private boolean isPlayerNameNotInit(PlayerName playerName) {
        return playerName == null;
    }

    private PlayerHpAndMp initPlayerHpAndMp() {
        PlayerHpAndMp playerHpAndMp;

        do {
            playerHpAndMp = inputPlayerHpAndMp();
        } while (isPlayerHpAndMpNotInit(playerHpAndMp));

        return playerHpAndMp;
    }

    private PlayerHpAndMp inputPlayerHpAndMp() {
        try {
            inputView.printUserInputMessage(INPUT_PLAYER_HP_AND_MP_MESSAGE);
            int[] playerHpAndMpInput = scanner.inputStringAndConvertToIntegerArrayBasedOnDelimiter(
                    2,
                    INPUT_PLAYER_HP_AND_MP_DELIMITER
            );
            return new PlayerHpAndMp(
                    playerHpAndMpInput[0],
                    playerHpAndMpInput[1]
            );
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(INVALID_PLAYER_HP_AND_MP_INPUT_ERROR_MESSAGE);
            return null;
        }
    }

    private boolean isPlayerHpAndMpNotInit(PlayerHpAndMp playerHpAndMp) {
        return playerHpAndMp == null;
    }
}
