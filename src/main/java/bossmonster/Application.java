package bossmonster;

import bossmonster.IO.Input;
import bossmonster.IO.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Player player = new Player();

        input.playerName(player);

    }
}
