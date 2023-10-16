package bossmonster.controller;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.PlayerStatDto;

public class BossMonsterController {
    private final InputView inputView;

    public BossMonsterController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int bossMonsterHp = inputView.readBossMonsterHp();
        BossMonster bossMonster = new BossMonster(bossMonsterHp);
        String playerName = inputView.readPlayerName();
        PlayerStatDto playerStatDto = inputView.readPlayerStat();
        int playerHp = playerStatDto.getHp();
        int playerMp = playerStatDto.getMp();
        Player player = new Player(playerName, playerHp, playerMp);
        while (bossMonster.getHp().getCurrentEnergy() > 0) {
            int type = inputView.readAttackType();
            AttackType attackType = AttackType.fromType(type);
            player.attack(bossMonster, attackType);
        }
    }
}
