package bossmonster.IO;

import bossmonster.BossMonster;
import bossmonster.Player;

public class Output {
    public void startGame(Player player, BossMonster bossMonster){
        System.out.println("보스 레이드를 시작합니다!");
        Input input = new Input();
        battleField(player,bossMonster);
        input.playerAttack(player, bossMonster);
    }
    public void battleField(Player player, BossMonster bossMonster){
        System.out.println("============================");
        player.showState();
    }
}
