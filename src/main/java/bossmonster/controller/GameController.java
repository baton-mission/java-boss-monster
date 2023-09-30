package bossmonster.controller;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.util.List;

public class GameController {

    private final int END = 0;

    private int turnCount;
    private InputView inputView;
    private OutputView outputView;

    public void play() {
        Player player = new Player();
        BossMonster bossMonster = new BossMonster();

        inputView = new InputView();
        outputView = new OutputView();
        turnCount = 1;

        progressInitialSetting(player, bossMonster);
        progressBattle(player, bossMonster);
    }

    private void progressInitialSetting(Player player, BossMonster bossMonster) {
        progressBossHpSetting(bossMonster);
        progressPlayerNameSetting(player);
        progressPlayerStatusSetting(player);

    }

    private int progressBossHpSetting(BossMonster bossMonster) {
        int bossMonsterHp = inputView.readBossMonsterHp();

        try {
            bossMonster.setHp(bossMonsterHp);
        } catch (IllegalArgumentException e) {
            outputView.printBossHpException();
            return progressBossHpSetting(bossMonster);
        }

        return END;
    }

    private int progressPlayerNameSetting(Player player) {
        String playerName = inputView.readPlayerName();

        try {
            player.setName(playerName);
        } catch (IllegalArgumentException e) {
            outputView.printPlayerNameException();
            return progressPlayerNameSetting(player);
        }

        return END;
    }

    private int progressPlayerStatusSetting(Player player) {
        List<Integer> playerStatus = inputView.readPlayerHpAndMp();

        try {
            player.setStatus(playerStatus.get(0), playerStatus.get(1));
        } catch (IllegalArgumentException e) {
            outputView.printPlayerStatusException();
            return progressPlayerStatusSetting(player);
        }

        return END;
    }

    private void progressBattle(Player player, BossMonster bossMonster) {
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
