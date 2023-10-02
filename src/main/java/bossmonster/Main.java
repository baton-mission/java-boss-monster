package bossmonster;

import bossmonster.controller.GameController;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController(inputView(), outputView());
        controller.run();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
