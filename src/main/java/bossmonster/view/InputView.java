package bossmonster.view;

import java.util.Scanner;

public class InputView {

    public static int readBossMonsterHp(Scanner scanner) {
        return toInt(scanner.nextLine());
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }

    public static String readPlayerName(Scanner scanner) {
        return scanner.nextLine();
    }
}
