package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.view.InputView;

public class BossMonsterController {
    private final InputView inputView;

    public BossMonsterController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int bossMonsterHp = inputView.readBossMonsterHp();
        BossMonster bossMonster = new BossMonster(bossMonsterHp);
    }
}
