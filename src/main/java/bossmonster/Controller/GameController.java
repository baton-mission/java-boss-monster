package bossmonster.Controller;

import java.util.Scanner;

public class GameController {
    private Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getGameHp() {
        int hp = scanner.nextInt();

        return hp;
    }

    public int getAttackType() {
        int attackType = scanner.nextInt();

        return attackType;
    }
}
