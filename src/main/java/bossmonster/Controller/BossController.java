package bossmonster.Controller;

import java.util.Scanner;

public class BossController {
    private Scanner scanner;

    public BossController(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getBossHp() {
        int hp = scanner.nextInt();

        return hp;
    }
}
