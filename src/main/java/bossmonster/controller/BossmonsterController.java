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
        int bossHP = 0;
        try {
            bossHP = inputView.inputBossHP();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initBoss();
        }
        return new Boss(bossHP);
    }

    public Player initPlayer() {
        String name = inputView.inputPlayerName();
        List<Integer> playerHPAndMP = inputView.inputPlayerHpAndMp();
        return new Player(playerHPAndMP.get(0), playerHPAndMP.get(1), name);
    }
}
