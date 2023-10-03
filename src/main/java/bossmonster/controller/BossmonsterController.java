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
        return new Boss(getBossHP());
    }

    public int getBossHP() {
        try {
            return inputView.inputBossHP();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBossHP();
        }
    }

    public Player initPlayer() {
        String name = getPlayerName();
        List<Integer> playerHPAndMP = getPlayerHPAndMP();

        return new Player(playerHPAndMP.get(0), playerHPAndMP.get(1), name);
    }

    public List<Integer> getPlayerHPAndMP() {
        try {
            return inputView.inputPlayerHpAndMp();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerHPAndMP();
        }

    }

    public String getPlayerName() {
        try {
            return inputView.inputPlayerName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerName();
        }
    }
}
