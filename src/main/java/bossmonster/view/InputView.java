package bossmonster.view;

import java.util.Scanner;

public class InputView {
    public static final String READ_BOSS_MONSTER_HP_MESSAGE = "보스 몬스터의 HP를 입력해주세요.";
    public static final String NOT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readBossMonsterHp() {
        print(READ_BOSS_MONSTER_HP_MESSAGE);
        return parseInt(scanner.nextLine());
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
