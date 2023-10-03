package bossmonster;

import bossmonster.game.GameClient;
import bossmonster.game.GameFactory;

public class Application {
    public static void main(String[] args) {

        GameFactory gameFactory = new GameFactory();
        GameClient game = gameFactory.createGame();
        game.run();
    }
}
