package bossmonster;

import bossmonster.controller.GameController;
import bossmonster.repository.AttackTypeRepository;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class Application {
    public static void main(String[] args) {
        AttackTypeRepository attackTypeRepository = new AttackTypeRepository();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(attackTypeRepository, inputView, outputView);
        gameController.play();
    }
}
