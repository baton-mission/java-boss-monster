package bossmonster.io;

import bossmonster.Application;
import bossmonster.character.BossMonster;
import bossmonster.character.Player;

public class Output {
    public static  void startGame() {
        System.out.println("\n보스 레이드를 시작합니다!\n");
        Application.turn();
    }

    public static void battleField(Player player, BossMonster bossMonster) {
        System.out.println("============================");
        bossMonster.showState();
        System.out.println();
        player.showState();
        System.out.println("============================");
    }
}
