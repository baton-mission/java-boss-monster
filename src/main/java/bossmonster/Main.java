package bossmonster;

import bossmonster.controller.BossGameController;
import bossmonster.domain.DamageStrategy;
import bossmonster.domain.RandomDamageStrategy;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class Main {
    public static void main(String[] args) {
        DamageStrategy damageStrategy = new RandomDamageStrategy();
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();
        BossGameController bossGameController = new BossGameController(inputView, outputView, damageStrategy);
        bossGameController.run();
    }
}
