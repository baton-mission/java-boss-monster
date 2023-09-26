package bossmonster.IO;

import java.util.Scanner;

import bossmonster.BossMonster;
import bossmonster.Player;

public class Input {
    public static void playerName(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n플레이어의 이름을 입력해주세요");
        try {
           player.createName(scanner.next());
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            playerName(player);
        }
    }

    public static void bossHP(BossMonster bossMonster) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        try {
            bossMonster.createHP(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            bossHP(bossMonster);
        }
    }

    public static void playerHPMP(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        scanner = new Scanner(scanner.next()).useDelimiter("\\s*,\\s*");
        try {
            player.createHPMP(scanner.nextInt(), scanner.nextInt());
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            playerHPMP(player);
        }
    }

    public static void playerAttack(Player player,BossMonster bossMonster) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n어떤 공격을 하시겠습니까?\n1. 물리 공격\n2. 마법 공격");
        try {
            player.attack(scanner.nextInt(), bossMonster);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            playerAttack(player, bossMonster);
        }
    }
}
