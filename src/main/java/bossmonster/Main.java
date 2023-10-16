package bossmonster;

import bossmonster.controller.BossMonsterController;
import bossmonster.view.InputView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        new BossMonsterController(inputView).run();
    }
}
