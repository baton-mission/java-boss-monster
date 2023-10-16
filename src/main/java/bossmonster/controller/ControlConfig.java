package bossmonster.controller;

import bossmonster.service.BattleService;
import bossmonster.service.CreatureService;
import bossmonster.service.ResultService;
import bossmonster.view.inputview.BattleInputView;
import bossmonster.view.inputview.StartInputView;
import bossmonster.view.outputview.BattleOutputView;
import bossmonster.view.outputview.ErrorOutputView;
import bossmonster.view.outputview.ResultOutputView;
import bossmonster.view.outputview.StartOutputView;

public class ControlConfig {
    public static Controller controlCreature() {
        return new CreatureController(
                new CreatureService(),
                new StartInputView(),
                new StartOutputView(new ErrorOutputView()));
    }

    public static Controller controlBattle() {
        return new BattleController(new BattleService(),
                new BattleInputView(),
                new BattleOutputView(new ErrorOutputView()));
    }

    public static Controller controlResult() {
        return new ResultController(new ResultService(),
                new ResultOutputView());
    }
}
