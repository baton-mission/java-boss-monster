package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.service.Battle;
import bossmonster.service.InitialSetting;

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
    }
}
