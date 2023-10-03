package bossmonster.controller;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.util.List;

public class GameController {

    private static final int END = 0;
    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        BossMonster bossMonster = progressBossHpSetting();
        Player player = progressPlayerInitialSetting();
        int turnCount = 1;

        progressBattle(player, bossMonster, turnCount);
    }

    private BossMonster progressBossHpSetting() {
        int bossMonsterHp = inputView.readBossMonsterHp();

        try {
            BossMonster bossMonster = new BossMonster(bossMonsterHp);
            return bossMonster;
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return progressBossHpSetting();
        }
    }

    private Player progressPlayerInitialSetting() {
        String playerName = progressPlayerNameSetting();
        List<Integer> playerStatus = progressPlayerStatusSetting();

        try {
            Player player = new Player(playerName, playerStatus.get(0), playerStatus.get(1));
            return player;
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return progressPlayerInitialSetting();
        }
    }

    private String progressPlayerNameSetting() {
        try {
            String playerName = inputView.readPlayerName();
            Player.validatePlayerName(playerName);
            return playerName;
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return progressPlayerNameSetting();
        }
    }

    private List<Integer> progressPlayerStatusSetting() {
        try {
            List<Integer> playerStatus = inputView.readPlayerHpAndMp();
            Player.validatePlayerStatus(playerStatus.get(0), playerStatus.get(1));
            return playerStatus;
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return progressPlayerStatusSetting();
        }
    }
    private void progressBattle(Player player, BossMonster bossMonster, int turnCount) {
        outputView.printBattleStartView();

        while (true) {
            outputView.printBattleInfoView(player, bossMonster, turnCount);
            progressPlayerPhase(player, bossMonster);
            if (player.isVictory(bossMonster)) {
                endGameByPlayerVictory(player, turnCount);
                break;
            }

            int bossDamage = bossMonster.attackPlayer(player);
            outputView.printBossPhaseView(bossDamage);
            if (bossMonster.isVictory(player)) {
                endGameByPlayerDefeat(player, bossMonster, turnCount);
                break;
            }

            turnCount++;
        }
    }

    private int progressPlayerPhase(Player player, BossMonster bossMonster) {
        int attackTypeNum = inputView.readAttackType();
        AttackType attackType = new AttackType();

        try {
            attackType.setType(attackTypeNum);
        } catch (IllegalArgumentException e) {
            outputView.printAttackTypeException();
            return progressPlayerPhase(player, bossMonster);
        }

        try {
            player.attackBossMonster(bossMonster, attackType);
        } catch (IllegalArgumentException e) {
            outputView.printLackOfMPException();
            return progressPlayerPhase(player, bossMonster);
        }
        outputView.printPlayerPhaseView(attackType);

        return END;
    }



    private void endGameByPlayerVictory(Player player, int turnCount) {
        outputView.printEndGameByVictoryView(player, turnCount);
    }

    private void endGameByPlayerDefeat(Player player, BossMonster bossMonster, int turnCount) {
        outputView.printEndGameByDefeatView(player, bossMonster, turnCount);
    }
}
