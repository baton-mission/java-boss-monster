package bossmonster.controller;

import bossmonster.model.Boss;
import bossmonster.model.Player;
import bossmonster.service.BossmonsterService;
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
        printStartImage(boss, player);
        repeatRaid(boss, player);
    }

    public void repeatRaid(Boss boss, Player player) {
        while(true) {
            playerAttack(boss, player);
            if (boss.getHP() <= 0) {
                outputView.printEndRaid(player.getName(), player.getAttackNumber());
                break;
            }
            bossAttack(boss, player);
            if (player.getHP() <= 0) {
                player.modifyHP();
                printBossWinImage(boss, player);
                break;
            }
            printFightImage(boss, player);
        }
    }

    public void printStartImage(Boss boss, Player player) {
        outputView.printBossHP(boss.getHP(), boss.getMaxHP());
        outputView.printBossStartImage();
        outputView.printPlayerHPAndMP(player.getName(), player.getHP(), player.getMaxHP(),
                player.getMP(), player.getMaxMP());
    }

    public void printFightImage(Boss boss, Player player) {
        outputView.printBossHP(boss.getHP(), boss.getMaxHP());
        outputView.printBossAttackedImage();
        outputView.printPlayerHPAndMP(player.getName(), player.getHP(), player.getMaxHP(),
                player.getMP(), player.getMaxMP());
    }

    public void printBossWinImage(Boss boss, Player player) {
        outputView.printBossHP(boss.getHP(), boss.getMaxHP());
        outputView.printBossWinImage();
        outputView.printPlayerHPAndMP(player.getName(), player.getHP(), player.getMaxHP(),
                player.getMP(), player.getMaxMP());
        outputView.printFailedRaid(player.getName());
    }


    public void bossAttack(Boss boss, Player player) {
        int damage = BossmonsterService.bossDamage();
        outputView.printBossAttack(damage);
        player.subtractHP(damage);
    }

    public void playerAttack(Boss boss, Player player) {
        int attackMethod = inputView.inputAttackMethod();
        if(attackMethod == 2 && !isRemainPlayerMP(player)) {
            outputView.printCantUseMagicalAttack();
            attackMethod = 1;
        }
        if(attackMethod == 1) {
            outputView.printPhysicalAttack();
            boss.subtractHP(10);
            addPlayerMP(player);
        }
        if(attackMethod == 2) {
            outputView.printMagicalAttack();
            boss.subtractHP(20);
            player.subtractMP();
        }
        player.addAttackNumber();
    }

    public boolean isRemainPlayerMP(Player player) {
        return player.getMP() >= 30;
    }

    public void addPlayerMP(Player player) {
        player.addMP();
        if(player.getMP() >= player.getMaxMP()) {
            player.modifyMP();
        }
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
