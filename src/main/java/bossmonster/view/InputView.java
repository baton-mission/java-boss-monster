package  bossmonster.view;

import java.util.Scanner;

class InputView {
    private static final String INPUT_BOSS_HP = "보스 몬스터의 HP를 입력해주세요.";
    private static final String INPUT_PLAYER_NAME = "플레이어의 이름을 입력해주세요.";
    private static final String INPUT_PLAYER_HP_AND_MP = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";

    static Scanner scanner = new Scanner(System.in);

    public static String inputBossHP() {
        System.out.println(INPUT_BOSS_HP);
        return scanner.nextLine();
    }

    public static String inputPlayerName() {
        System.out.println(INPUT_PLAYER_NAME);
        return scanner.nextLine();
    }

    public static String getInputPlayerHpAndMp() {
        System.out.println(INPUT_PLAYER_HP_AND_MP);
        return scanner.nextLine();
    }
}