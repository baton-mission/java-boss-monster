package bossmonster.controller;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.PlayerStatDto;

public class BossMonsterController {
    private final InputView inputView;
    private final OutputView outputView;

    public BossMonsterController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int bossMonsterHp = inputView.readBossMonsterHp();
        BossMonster bossMonster = new BossMonster(bossMonsterHp);
        String playerName = inputView.readPlayerName();
        PlayerStatDto playerStatDto = inputView.readPlayerStat();
        int playerHp = playerStatDto.getHp();
        int playerMp = playerStatDto.getMp();
        Player player = new Player(playerName, playerHp, playerMp);
        while (bossMonster.getHp().getCurrentEnergy() > 0 && player.getHp().getCurrentEnergy() > 0) {
            int type = inputView.readAttackType();
            AttackType attackType = AttackType.fromType(type);

            int beforeBossHp = bossMonster.getHp().getCurrentEnergy();
            player.attack(bossMonster, attackType);
            int afterBossHp = bossMonster.getHp().getCurrentEnergy();
            outputView.printPlayerAttack(beforeBossHp - afterBossHp, attackType);

            int beforePlayerHp = player.getHp().getCurrentEnergy();
            bossMonster.attack(player);
            int afterPlayerHp = player.getHp().getCurrentEnergy();
            outputView.printBossAttack(beforePlayerHp - afterPlayerHp);
        }
    }
}
