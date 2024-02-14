package bossmonster.Controller;

import java.util.Scanner;

public class BossController {
    private Scanner scanner;

    public BossController(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getBossHp() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        int hp = scanner.nextInt();

        return hp;
    }
}
