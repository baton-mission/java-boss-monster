package bossmonster.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";

    public static int readBossMonsterHp(Scanner scanner) {
        return toInt(scanner.nextLine());
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }

    public static String readPlayerName(Scanner scanner) {
        return scanner.nextLine();
    }

    public static List<Integer> readPlayerInitialHpAndMp(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                        .split(DELIMITER))
                .map(InputView::toInt)
                .toList();
    }
}
