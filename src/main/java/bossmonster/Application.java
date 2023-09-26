package bossmonster;

import bossmonster.IO.Input;
import bossmonster.IO.Output;

public class Application {

    private static final Player PLAYER = new Player();
    private static final BossMonster BOSS_MONSTER = new BossMonster();

    public static void main(String[] args) {
        Input.bossHP(BOSS_MONSTER);
        Input.playerName(PLAYER);
        Input.playerHPMP(PLAYER);
        Output.startGame();
    }

    public static void turn() {
        Output.battleField(PLAYER, BOSS_MONSTER);
        Input.playerAttack(PLAYER, BOSS_MONSTER);
    }
}
