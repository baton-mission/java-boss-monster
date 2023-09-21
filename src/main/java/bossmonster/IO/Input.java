package bossmonster.IO;

import bossmonster.BossMonster;
import bossmonster.Player;

import java.util.Scanner;

public class Input {
    public void playerName(Player player){

        Scanner scanner = new Scanner(System.in);
        System.out.println("플레이어의 이름을 입력해주세요");
        player.createName(scanner.next());
    }

    public void bossHP(BossMonster bossMonster){
        Scanner scanner = new Scanner(System.in);
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        bossMonster.createHP(scanner.nextInt());
    }
}
