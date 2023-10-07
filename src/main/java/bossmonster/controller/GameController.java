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
        OutputView.printDefaultBoss(bossMonster, PlayerDto.Status.from(player));
        playerBossTransaction(player, bossMonster, 1);
    }

    private Player generatePlayer() {
        String name = inputView.inputPlayerName();
        PlayerDto.HpMp hpMp = inputView.inputHpMp();

        return new Player(name, hpMp.getHp(), hpMp.getMp());
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
            OutputView.printSadBoss(bossMonster, PlayerDto.Status.from(player));
            OutputView.printPlayerWin(PlayerDto.Status.from(player), count);
            return false;
        }
        
        int bossAttackDamage = bossMonster.attack();
        player.attacked(bossAttackDamage);
        if (player.isDead()) {
            OutputView.printHappyBoss(bossMonster, PlayerDto.Status.from(player));
            OutputView.printBossMonsterWin(PlayerDto.Status.from(player), count);
            return false;
        }

        OutputView.printSadBoss(bossMonster, PlayerDto.Status.from(player));
        OutputView.printDamageByPlayer(playerAttackType);
        OutputView.printDamageByBossMonster(bossAttackDamage);

        return playerBossTransaction(player, bossMonster, count + 1);
    }
}
