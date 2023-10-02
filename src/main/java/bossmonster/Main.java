package bossmonster;

import bossmonster.controller.GameController;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.run();
    }
}
