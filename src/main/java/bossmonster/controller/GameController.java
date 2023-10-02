package bossmonster.controller;

import bossmonster.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class GameController {
    InputView inputView = new InputView();

    private Player generatePlayer() {
        String name = inputView.inputPlayerName();
        int[] hpMp = inputView.inputHpMp();

        return new Player(name, hpMp[0], hpMp[1]);
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
            OutputView.bossSad(bossMonster, player);
            OutputView.playerWin(player, count);
            return false;
        }
        
        int bossAttackDamage = bossMonster.attack();
        player.attacked(bossAttackDamage);
        if (player.isDead()) {
            OutputView.bossHappy(bossMonster, player);
            OutputView.bossMonsterWin(player, count);
            return false;
        }

        OutputView.bossSad(bossMonster, player);
        OutputView.damageByPlayer(playerAttackType);
        OutputView.damageByBossMonster(bossAttackDamage);

        return playerBossTransaction(player, bossMonster, count + 1);
    }
}
