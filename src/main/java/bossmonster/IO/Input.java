package bossmonster.IO;

import bossmonster.BossMonster;
import bossmonster.Player;

import java.util.Scanner;

public class Input {
    public void playerName(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n플레이어의 이름을 입력해주세요");
        player.createName(scanner.next());
    }

    public void bossHP(BossMonster bossMonster){
        Scanner scanner = new Scanner(System.in);
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        bossMonster.createHP(scanner.nextInt());
    }

    public void playerHPMP(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        scanner = new Scanner(scanner.next()).useDelimiter("\\s*,\\s*");
        player.createHPMP(scanner.nextInt(),scanner.nextInt());
    }
    public void playerAttack(Player player,BossMonster bossMonster){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n어떤 공격을 하시겠습니까?\n1. 물리 공격\n2. 마법 공격");
        player.attack(scanner.nextInt(),bossMonster);
    }


}
