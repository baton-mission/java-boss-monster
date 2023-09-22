package bossmonster.IO;

import bossmonster.Application;
import bossmonster.BossMonster;
import bossmonster.Player;
import bossmonster.VO.HP;

public class Output {
    Input input = new Input();
    public void startGame(){
        System.out.println("보스 레이드를 시작합니다!");
        Application.turn();
    }
    public void battleField(Player player, BossMonster bossMonster){
        System.out.println("============================");
        bossMonster.showState();
        player.showState();
    }

}
