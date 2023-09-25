package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.dto.StatusDto;
import bossmonster.service.Battle;
import bossmonster.service.InitialSetting;
import bossmonster.view.GameView;

import java.util.ArrayList;
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
            // TODO: 뷰에서 데이터 받아와서 공격 타입 삽입
            StatusDto statusDto = new StatusDto(bossMonster, player);
            battle.attackBossMonster(player, bossMonster, 1);
            if (battle.isVictory(bossMonster)) {
                endGameByVictory();
                break;
            }

            int bossDamage = battle.attackPlayer(player);
            if (battle.isDefeat(player)) {
                endGameByDefeat();
                break;
            }
        }
    }

    private void endGameByVictory() {

    }

    private void endGameByDefeat() {

    }
}
