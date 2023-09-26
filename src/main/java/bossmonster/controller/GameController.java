package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.dto.BattleInfoDto;
import bossmonster.service.Battle;
import bossmonster.service.InitialSetting;
import bossmonster.view.GameView;

import java.util.List;

public class GameController {

    int turnCount;
    Player player;
    BossMonster bossMonster;
    InitialSetting initialSetting;
    Battle battle;
    GameView gameView;

    public GameController() {
        initialSetting = new InitialSetting();
        battle = new Battle();
        gameView = new GameView();
    }

    public void play() {
        turnCount = 1;
        progressInitialSetting();
        progressBattle();
    }

    private void progressInitialSetting() {
        int bossMonsterHp = gameView.printBossHpSettingView();
        String playerName = gameView.printPlayerNameSettingView();
        List<Integer> playerStatus = gameView.printPlayerStatusSettingView();

        initialSetting.setPlayerStatus(playerName, playerStatus);
        initialSetting.setBossMonsterStatus(bossMonsterHp);
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
