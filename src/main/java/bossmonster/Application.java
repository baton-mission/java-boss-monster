package bossmonster;

import bossmonster.IO.Input;
import bossmonster.IO.Output;

public class Application {


    private static Input input = new Input();
    private static Output output = new Output();
    private static Player player = new Player();
    private static BossMonster bossMonster = new BossMonster();;
    public static void main(String[] args) {

        input.bossHP(bossMonster);
        input.playerName(player);
        input.playerHPMP(player);
        output.startGame();
    }
    public static void turn(){
        output.battleField(player,bossMonster);
        input.playerAttack(player,bossMonster);
    }
}
