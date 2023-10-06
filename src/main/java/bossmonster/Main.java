package bossmonster;

import bossmonster.controller.GameController;
import bossmonster.view.GameView;
import bossmonster.view.Input;
import bossmonster.view.Output;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = new Input(new Scanner(System.in));
        Output output = new Output();
        GameView gameView = new GameView(input,output);
        GameController game = new GameController(gameView);
        game.play();




    }
}
