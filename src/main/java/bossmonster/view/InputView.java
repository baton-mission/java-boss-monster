package  bossmonster.view;

import java.util.List;
import java.util.Scanner;
import bossmonster.validation.InputValidation;

public class InputView {
    private static final String INPUT_BOSS_HP = "보스 몬스터의 HP를 입력해주세요.";
    private static final String INPUT_PLAYER_NAME = "플레이어의 이름을 입력해주세요.";
    private static final String INPUT_PLAYER_HP_AND_MP = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";

    static Scanner scanner = new Scanner(System.in);

    public static int inputBossHP() {
        System.out.println(INPUT_BOSS_HP);
        return InputValidation.validBossHP(scanner.nextLine());
    }

    public static String inputPlayerName() {
        System.out.println(INPUT_PLAYER_NAME);
        return InputValidation.validPlayerName(scanner.nextLine());
    }

    public static List<Integer> getInputPlayerHpAndMp() {
        System.out.println(INPUT_PLAYER_HP_AND_MP);
        return InputValidation.validPlayerHPAndMP(scanner.nextLine());
    }
}