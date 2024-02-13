package bossmonster.Controller;

import bossmonster.Domain.Boss;
import java.util.Scanner;

public class BossController {
    private Boss nowRoundBoss;
    private Scanner scanner;

    public BossController(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getBossHp() {
        int hp = scanner.nextInt();

        return hp;
    }
}
