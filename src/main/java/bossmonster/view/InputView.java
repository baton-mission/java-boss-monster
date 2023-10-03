package  bossmonster.view;

import java.util.List;
import java.util.Scanner;
import bossmonster.validation.InputValidation;

public class InputView {
    private static final String INPUT_BOSS_HP = "보스 몬스터의 HP를 입력해주세요.";
    private static final String INPUT_PLAYER_NAME = "플레이어의 이름을 입력해주세요.";
    private static final String INPUT_PLAYER_HP_AND_MP = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";
    private static final String INPUT_ATTACK_METHOD = "어떤 공격을 하시겠습니까?\n 1. 물리 공격\n 2. 마법 공격";


    static Scanner scanner = new Scanner(System.in);

    public int inputBossHP() {
        System.out.println(INPUT_BOSS_HP);
        return InputValidation.validBossHP(scanner.nextLine());
    }

    public String inputPlayerName() {
        System.out.println(INPUT_PLAYER_NAME);
        return InputValidation.validPlayerName(scanner.nextLine());
    }

    public List<Integer> inputPlayerHpAndMp() {
        System.out.println(INPUT_PLAYER_HP_AND_MP);
        return InputValidation.validPlayerHPAndMP(scanner.nextLine());
    }

    public int inputAttackMethod() {
        System.out.println(INPUT_ATTACK_METHOD);
        return InputValidation.validAttackMethod(scanner.nextLine());
    }
}