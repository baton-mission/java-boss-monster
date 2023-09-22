package bossmonster.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BOSS_HP = "보스 몬스터의 HP를 입력해주세요.";

    Scanner scanner = new Scanner(System.in);

    public String inputBossHP() {
        System.out.println(INPUT_BOSS_HP);
        return scanner.nextLine();
    }
}
