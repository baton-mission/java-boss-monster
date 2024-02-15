package bossmonster.Controller;

import java.util.Scanner;

public class GameController {
    private Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getAttackType() {
        System.out.println("어떤 공격을 하시겠습니까?\n"
                + "1. 물리 공격\n"
                + "2. 마법 공격");
        int attackType = scanner.nextInt();

        return attackType;
    }

    public void printStartMessage() {
        System.out.println("보스 레이드를 시작합니다!\n");
    }
}
