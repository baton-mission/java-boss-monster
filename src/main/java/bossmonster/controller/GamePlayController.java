package bossmonster.controller;

import bossmonster.domain.bossmonster.BossMonster;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.constant.PlayerAttackOption;
import bossmonster.domain.player.dto.PlayerAttackResult;
import bossmonster.domain.scanner.GameInputScanner;
import bossmonster.view.ErrorView;
import bossmonster.view.InputView;
import bossmonster.view.ResultView;

import static bossmonster.domain.player.constant.PlayerAttackOption.MAGIC;
import static bossmonster.domain.player.constant.PlayerAttackOption.PHYSICAL;
import static bossmonster.domain.player.constant.PlayerOption.MAGIC_ATTACK_OPTION;
import static bossmonster.domain.player.constant.PlayerOption.PHYSICAL_ATTACK_OPTION;
import static bossmonster.view.message.ErrorMessage.INVALID_PLAYER_ATTACK_OPTION_INPUT_ERROR_MESSAGE;
import static bossmonster.view.message.ErrorMessage.PLAYER_MP_NOT_ENOUGH_ERROR_MESSAGE;
import static bossmonster.view.message.InputMessage.INPUT_PLAYER_ATTACK_OPTION;
import static bossmonster.view.message.ResultMessage.*;

public class GamePlayController {

    private final BossMonster bossMonster;
    private final Player player;
    private final GameInputScanner scanner;
    private final InputView inputView;
    private final ResultView resultView;
    private final ErrorView errorView;

    public GamePlayController(
            BossMonster bossMonster,
            Player player,
            GameInputScanner scanner,
            InputView inputView,
            ResultView resultView,
            ErrorView errorView
    ) {
        this.bossMonster = bossMonster;
        this.player = player;
        this.scanner = scanner;
        this.inputView = inputView;
        this.resultView = resultView;
        this.errorView = errorView;
    }

    public void displayGameStart() {
        resultView.printStartGame();
        resultView.printCharacterStatus(
                bossMonster.getBossMonsterInfo(),
                BOSS_MONSTER_NORMAL_IMAGE,
                player.getPlayerInfo()
        );
    }

    public void displayCharacterStatus() {
        resultView.printCharacterStatus(
                bossMonster.getBossMonsterInfo(),
                BOSS_MONSTER_ATTACKED_IMAGE,
                player.getPlayerInfo()
        );
    }

    public void playerAttack() {
        PlayerAttackResult result = processPlayerAttack();

        resultView.printPlayerAttackResult(
                result.getPlayerAttackName(),
                result.getAttackDamage()
        );
    }

    private PlayerAttackResult processPlayerAttack() {
        PlayerAttackResult result;

        do {
            PlayerAttackOption playerAttackOption = inputPlayerAttackOption();
            result = attemptPlayerAttack(playerAttackOption);
        } while (!result.isSuccess());

        return result;
    }

    private PlayerAttackOption inputPlayerAttackOption() {
        try {
            inputView.printUserInputMessage(INPUT_PLAYER_ATTACK_OPTION);
            return convertInputToPlayerAttackOption(scanner.inputNumber());
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(INVALID_PLAYER_ATTACK_OPTION_INPUT_ERROR_MESSAGE);
            return null;
        }
    }

    private PlayerAttackResult attemptPlayerAttack(PlayerAttackOption playerAttackOption) {
        if (playerAttackOption == null) return null;

        try {
            int attackDamage = player.attackBossMonster(
                    bossMonster,
                    playerAttackOption
            );

            return PlayerAttackResult.of(
                    true,
                    playerAttackOption.getAttackName(),
                    attackDamage
            );
        } catch (IllegalStateException e) {
            errorView.printErrorMessage(PLAYER_MP_NOT_ENOUGH_ERROR_MESSAGE);
            return PlayerAttackResult.of(
                    false,
                    "NO_ATTACK",
                    0
            );
        }
    }

    private PlayerAttackOption convertInputToPlayerAttackOption(int input) {
        if (input == PHYSICAL_ATTACK_OPTION) return PHYSICAL;
        if (input == MAGIC_ATTACK_OPTION) return MAGIC;
        return null;
    }

    public void bossMonsterAttack() {
        int attackDamage = bossMonster.attackPlayer(player);
        resultView.printBossMonsterAttackResult(attackDamage);
    }

    public boolean isGameNotContinuable() {
        return !player.isAlive() || !bossMonster.isAlive();
    }

    public void playerWin(int gameTurn) {
        resultView.printPlayerWin(
                player.getPlayerInfo().getPlayerName(),
                gameTurn
        );

    }

    public void bossMonsterWin() {
        resultView.printBossMonsterWin(
                bossMonster.getBossMonsterInfo(),
                BOSS_MONSTER_WIN_IMAGE,
                player.getPlayerInfo()
        );
    }
}
