package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.service.Battle;
import bossmonster.service.InitialSetting;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    Player player;
    BossMonster bossMonster;
    InitialSetting initialSetting;
    Battle battle;

    public GameController() {
        initialSetting = new InitialSetting();
        battle = new Battle();
    }

    public void play() {
        progressInitialSetting();
    }

    public void progressInitialSetting() {
        /**
         * 임시 데이터 삽입
         */
        String playerName = "testName";
        List<Integer> playerStatus = new ArrayList<>();
        playerStatus.add(150);
        playerStatus.add(50);
        int bossMonsterHp = 150;

        // TODO: 뷰에서 데이터 받아와서 삽입

        initialSetting.setPlayerStatus(playerName, playerStatus);
        initialSetting.setBossMonsterStatus(bossMonsterHp);
    }
}
