package bossmonster.controller;

import bossmonster.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.dto.BossMonsterDto;
import bossmonster.dto.PlayerDto;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class GameController {
    InputView inputView = new InputView();

    public void game() {
        BossMonster bossMonster = generateBossMonster();
        Player player = generatePlayer();
        OutputView.printDefaultBoss(BossMonsterDto.from(bossMonster), PlayerDto.Status.from(player));
        playerBossTransaction(player, bossMonster);
    }

    private Player generatePlayer() {
        String name = inputView.inputPlayerName();
        PlayerDto.HpMp hpMp = inputView.inputHpMp();

        return new Player(name, hpMp.getHp(), hpMp.getMp());
    }

    private BossMonster generateBossMonster() {
        return new BossMonster(inputView.inputBossHp());
    }


    private void playerBossTransaction(Player player, BossMonster bossMonster) {
        int count = 1;
        while (true) {
            AttackType playerAttackType = inputView.inputAttackType();
            if (!player.hasMp(playerAttackType)) { continue; }
            if (playerKilledBoss(player, bossMonster, playerAttackType, count)) { break; }

            int bossAttackDamage = bossMonster.attack();
            if (bossKilledPlayer(player, bossMonster, bossAttackDamage, count)) { break; }
            OutputView.printNextTurn(PlayerDto.Status.from(player),
                    BossMonsterDto.from(bossMonster), playerAttackType, count);
            count++;
        }
    }

    private Boolean playerKilledBoss(Player player, BossMonster bossMonster, AttackType attackType, int count) {
        bossMonster.attacked(player.attack(attackType));

        if (bossMonster.isDead()) {
            OutputView.printSadBoss(BossMonsterDto.from(bossMonster), PlayerDto.Status.from(player));
            OutputView.printPlayerWin(PlayerDto.Status.from(player), count);
            return true;
        }
        return false;
    }

    private Boolean bossKilledPlayer(Player player, BossMonster bossMonster, int bossDamage, int count) {
        player.attacked(bossDamage);
        if(player.isDead()) {
            OutputView.printHappyBoss(BossMonsterDto.from(bossMonster), PlayerDto.Status.from(player));
            OutputView.printBossMonsterWin(PlayerDto.Status.from(player), count);
            return true;
        }
        return false;
    }
}
