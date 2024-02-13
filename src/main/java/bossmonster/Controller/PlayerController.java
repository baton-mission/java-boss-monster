package bossmonster.Controller;

import bossmonster.Domain.Player;
import java.util.Scanner;

public class PlayerController {
    private Player nowRoundPlayer;
    private Scanner scanner;

    public PlayerController(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getPlayerName() {
        String name = scanner.nextLine();

        return name;
    }

    public int[] getPlayerHpMp() {
        // 입력 형식은 "100,50" 이런식으로 입력받는다.
        String[] hpMp = scanner.nextLine().split(",");
        int hp = Integer.parseInt(hpMp[0]);
        int mp = Integer.parseInt(hpMp[1]);

        return new int[]{hp, mp};
    }
}
