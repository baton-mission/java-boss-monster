package bossmonster.controller;

import bossmonster.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.dto.PlayerDto;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class GameController {
    InputView inputView = new InputView();

    public void game() {
        BossMonster bossMonster = generateBossMonster();
        Player player = generatePlayer();
        OutputView.printDefaultBoss(bossMonster, player);
        playerBossTransaction(player, bossMonster, 1);
    }

    private Player generatePlayer() {
        String name = inputView.inputPlayerName();
        PlayerDto playerDto = inputView.inputHpMp();

        return new Player(name, playerDto.getHp(), playerDto.getMp());
    }

    private BossMonster generateBossMonster() {
        return new BossMonster(inputView.inputBossHp());
    }

    private AttackType userInputAttackType() {
        return inputView.inputAttackType();
    }

    private Boolean playerBossTransaction(Player player, BossMonster bossMonster, int count) {
        AttackType playerAttackType = userInputAttackType();
        try {
            bossMonster.attacked(player.attack(playerAttackType));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return playerBossTransaction(player, bossMonster, count);
        }

        if (bossMonster.isDead()) {
            OutputView.printSadBoss(bossMonster, player);
            OutputView.printPlayerWin(player, count);
            return false;
        }
        
        int bossAttackDamage = bossMonster.attack();
        player.attacked(bossAttackDamage);
        if (player.isDead()) {
            OutputView.printHappyBoss(bossMonster, player);
            OutputView.printBossMonsterWin(player, count);
            return false;
        }

        OutputView.printSadBoss(bossMonster, player);
        OutputView.printDamageByPlayer(playerAttackType);
        OutputView.printDamageByBossMonster(bossAttackDamage);

        return playerBossTransaction(player, bossMonster, count + 1);
    }
}
