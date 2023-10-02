package bossmonster.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int readBossMonsterHp(Scanner scanner) {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        return toInt(scanner.nextLine());
    }

    public static String readPlayerName(Scanner scanner) {
        System.out.println("플레이어의 이름을 입력해주세요.");
        return scanner.nextLine();
    }

    public static List<Integer> readPlayerInitialHpAndMp(Scanner scanner) {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        return Arrays.stream(scanner.nextLine()
                        .split(","))
                .map(InputView::toInt)
                .toList();
    }

    public static int readPlayerAttackNumber(Scanner scanner) {
        System.out.println("어떤 공격을 하시겠습니까?\n" +
                           "1. 물리 공격\n" +
                           "2. 마법 공격");
        return toInt(scanner.nextLine());
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }
}
