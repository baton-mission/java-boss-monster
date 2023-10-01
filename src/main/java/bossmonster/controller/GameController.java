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
}
