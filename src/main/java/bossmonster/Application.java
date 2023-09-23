package bossmonster;

import bossmonster.IO.Input;
import bossmonster.IO.Output;

public class Application {
    private static final Player player = new Player();
    private static final BossMonster bossMonster = new BossMonster();
    public static void main(String[] args) {
        Input.bossHP(bossMonster);
        Input.playerName(player);
        Input.playerHPMP(player);
        Output.startGame();
    }
    public static void turn(){
        Output.battleField(player,bossMonster);
        Input.playerAttack(player,bossMonster);
    }
}
