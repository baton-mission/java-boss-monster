package bossmonster.view;

import bossmonster.domain.Boss;

import java.util.Scanner;

public class InputView {

    private final Scanner in;

    public InputView() {
        this.in = new Scanner(System.in);
    }

    public Boss getBossHP() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        String input = in.next();
        try {
            return new Boss(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBossHP();
        }
    }
}
