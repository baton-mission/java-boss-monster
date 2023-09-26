package bossmonster.controller;

import static bossmonster.util.RetryUtil.read;

import bossmonster.dto.request.BossHpDto;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossGameController {

    private static final InputView INPUT_VIEW = InputView.INSTANCE;
    private static final OutputView OUTPUT_VIEW = OutputView.INSTANCE;

    public void run() {
        BossHpDto bossHpDto = read(INPUT_VIEW::scanBossHp);

    }
}
