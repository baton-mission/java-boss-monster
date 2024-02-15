package bossmonster.Controller;

import java.util.Scanner;

public class PlayerController {
    private Scanner scanner;

    public PlayerController(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getPlayerName() {
        System.out.println("플레이어의 이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println();

        return name;
    }

    public int[] getPlayerHpMp() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        String[] hpMp = scanner.nextLine().split(",");
        int hp = Integer.parseInt(hpMp[0]);
        int mp = Integer.parseInt(hpMp[1]);

        System.out.println();

        return new int[]{hp, mp};
    }

    public static void printPhysicalAttackMessage() {
        System.out.println("물리 공격을 했습니다. (입힌 데미지: 10)");
    }

    public static void printMagicalAttackMessage() {
        System.out.println("마법 공격을 했습니다. (입힌 데미지: 20)");
    }
}
