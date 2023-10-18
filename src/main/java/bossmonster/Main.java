package bossmonster;

import bossmonster.controller.GameController;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameController game = new GameController(new InputView(new Scanner(System.in)),
                new OutputView());
        game.run();
    }
}
