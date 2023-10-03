package bossmonster.controller;

import bossmonster.model.Boss;
import bossmonster.model.Player;
import bossmonster.view.InputView;

import java.util.List;

public class BossmonsterController {
    InputView inputView = new InputView();

    public void startProgram() {
        Boss boss = initBoss();
        Player player = initPlayer();

    }

    public Boss initBoss() {
        int bossHP = inputView.inputBossHP();
        return new Boss(bossHP);
    }

    public Player initPlayer() {
        List<Integer> playerHPandMP = inputView.inputPlayerHpAndMp();
        return new Player(playerHPandMP.get(0), playerHPandMP.get(1),
                                                inputView.inputPlayerName());
    }
}
