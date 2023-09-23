package bossmonster.IO;

import bossmonster.Application;
import bossmonster.BossMonster;
import bossmonster.Player;

public class Output {
    Input input = new Input();
    public static  void startGame(){
        System.out.println("\n보스 레이드를 시작합니다!\n");
        Application.turn();
    }
    public static void battleField(Player player, BossMonster bossMonster){
        System.out.println("============================");
        bossMonster.showState();
        System.out.println();
        player.showState();
        System.out.println("============================");
    }

}
