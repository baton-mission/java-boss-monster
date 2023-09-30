package bossmonster.controller;

import bossmonster.AttackType;
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
            System.out.println("[ERROR] 보스 체력은 100이상, 300이하여야합니다.");
            return progressBossHpSetting(bossMonster);
        }

        return END;
    }

    private int progressPlayerNameSetting(Player player) {
        String playerName = inputView.readPlayerName();

        try {
            player.setName(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 플레이어의 이름은 5자 이하만 가능합니다.");
            return progressPlayerNameSetting(player);
        }

        return END;
    }

    private int progressPlayerStatusSetting(Player player) {
        List<Integer> playerStatus = inputView.readPlayerHpAndMp();

        try {
            player.setStatus(playerStatus.get(0), playerStatus.get(1));
        } catch (IllegalArgumentException e) {
            System.out.println("HP와 MP의 합이 200이 되도록 입력해주세요.");
            return progressPlayerStatusSetting(player);
        }

        return END;
    }

    private void progressBattle(Player player, BossMonster bossMonster) {
        while (true) {
            BattleInfoDto battleInfoDto = new BattleInfoDto(bossMonster, player);

            outputView.printBattleInfoView(battleInfoDto, turnCount);
            int attackTypeNum = inputView.readAttackType(battleInfoDto);
            AttackType attackType = new AttackType(attackTypeNum);
            player.attackBossMonster(bossMonster, attackType);
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

    private void endGameByPlayerVictory(BattleInfoDto battleInfoDto, int turnCount) {
        outputView.printEndGameByVictoryView(battleInfoDto, turnCount);
    }

    private void endGameByPlayerDefeat(BattleInfoDto battleInfoDto, int turnCount) {
        outputView.printEndGameByDefeatView(battleInfoDto, turnCount);
    }
}
