package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.dto.BattleInfoDto;
import bossmonster.service.Battle;
import bossmonster.view.GameView;

import java.util.List;

public class GameController {

    final int END = 0;
    int turnCount;
    Player player;
    BossMonster bossMonster;
    Battle battle;
    GameView gameView;

    public void play() {
        turnCount = 1;
        battle = new Battle();
        gameView = new GameView();

        progressInitialSetting();
        progressBattle();
    }

    private void progressInitialSetting() {
        int bossMonsterHp = gameView.printBossHpSettingView();
        player = new Player();
        bossMonster = new BossMonster(bossMonsterHp);

        progressPlayerNameSetting();
        progressPlayerStatusSetting();
    }



    private int progressPlayerNameSetting() {
        String playerName = gameView.printPlayerNameSettingView();

        try {
            player.setName(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 플레이어의 이름은 5자 이하만 가능합니다.");
            return progressPlayerNameSetting();
        }

        return END;
    }

    private int progressPlayerStatusSetting() {
        List<Integer> playerStatus = gameView.printPlayerStatusSettingView();

        try {
            player.setStatus(playerStatus.get(0), playerStatus.get(1));
        } catch (IllegalArgumentException e) {
            System.out.println("HP와 MP의 합이 200이 되도록 입력해주세요.");
            return progressPlayerStatusSetting();
        }

        return END;
    }

    private void progressBattle() {
        while (true) {
            BattleInfoDto battleInfoDto = new BattleInfoDto(bossMonster, player);
            int attackType = gameView.printPlayerPhaseView(battleInfoDto, turnCount);
            battle.attackBossMonster(player, bossMonster, attackType);
            if (battle.isVictory(bossMonster)) {
                endGameByVictory(battleInfoDto, turnCount);
                break;
            }

            int bossDamage = battle.attackPlayer(player);
            gameView.printBossPhaseView(bossDamage);
            if (battle.isDefeat(player)) {
                endGameByDefeat(battleInfoDto, turnCount);
                break;
            }

            turnCount++;
        }
    }

    private void endGameByVictory(BattleInfoDto battleInfoDto, int turnCount) {
        gameView.printEndGameByVictoryView(battleInfoDto, turnCount);
    }

    private void endGameByDefeat(BattleInfoDto battleInfoDto, int turnCount) {
        gameView.printEndGameByDefeatView(battleInfoDto, turnCount);
    }
}
