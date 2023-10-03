package bossmonster.controller;

import bossmonster.model.Boss;
import bossmonster.model.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.util.List;

public class BossmonsterController {
    InputView inputView = new InputView();
    OutputView outputView= new OutputView();

    public void startProgram() {
        Boss boss = initBoss();
        Player player = initPlayer();
        outputView.printStartRaid();
        startRaid(boss, player);
    }

    public void startRaid(Boss boss, Player player) {
        outputView.printBossHP(boss.getHP(), boss.getMaxHP());
        outputView.printBossStartImage();
        outputView.printPlayerHPAndMP(player.getName(), player.getHP(), player.getMaxHP(),
                player.getMP(), player.getMaxMP());
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
