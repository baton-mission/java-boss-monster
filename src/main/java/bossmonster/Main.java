package bossmonster;

import bossmonster.controller.GameController;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameController(inputView(), outputView());
        controller.run();
    }

    private static InputView inputView() {
        return new InputView(new Scanner(System.in));
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
