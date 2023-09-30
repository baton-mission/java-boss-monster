package bossmonster.controller;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.dto.BattleInfoDto;
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
            BattleInfoDto battleInfoDto = new BattleInfoDto(bossMonster, player);

            outputView.printBattleInfoView(battleInfoDto, turnCount);
            progressPlayerPhase(player, bossMonster);
            if (player.isVictory(bossMonster)) {
                endGameByPlayerVictory(battleInfoDto, turnCount);
                break;
            }

            int bossDamage = bossMonster.attackPlayer(player);
            outputView.printBossPhaseView(bossDamage);
            if (bossMonster.isVictory(player)) {
                endGameByPlayerDefeat(battleInfoDto, turnCount);
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

    private void endGameByPlayerVictory(BattleInfoDto battleInfoDto, int turnCount) {
        outputView.printEndGameByVictoryView(battleInfoDto, turnCount);
    }

    private void endGameByPlayerDefeat(BattleInfoDto battleInfoDto, int turnCount) {
        outputView.printEndGameByDefeatView(battleInfoDto, turnCount);
    }
}
