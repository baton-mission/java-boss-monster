package bossmonster.controller;

import static bossmonster.util.RetryUtil.read;

import bossmonster.domain.Boss;
import bossmonster.dto.request.BossHpDto;
import bossmonster.dto.request.PlayerNameDto;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossGameController {

    private static final InputView INPUT_VIEW = InputView.INSTANCE;
    private static final OutputView OUTPUT_VIEW = OutputView.INSTANCE;

    public void run() {
        Boss boss = read(this::createBoss);
        PlayerNameDto playerNameDto = read(INPUT_VIEW::scanPlayerNames);


    }

    private Boss createBoss() {
        BossHpDto bossHpDto = read(INPUT_VIEW::scanBossHp);
        return Boss.from(bossHpDto.getHp());
    }
}
