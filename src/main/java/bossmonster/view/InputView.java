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

    public String getPlayerName() {
        System.out.println("플레이어의 이름을 입력해주세요");
        try {
            String input = in.next();
            checkName(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerName();
        }
    }

    private void checkName(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("[ERROR] ");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }

    public int[] getPlayerStatus() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        String[] input = in.next().split(",");
        try {
            return convertStringToInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerStatus();
        }
    }

    private int[] convertStringToInt(String[] input) {
        int[] temp = new int[2];
        try {
            for (int i = 0; i < 2; i++) {
                temp[i] = Integer.parseInt(input[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
        checkSum(temp);
        return temp;
    }

    private void checkSum(int[] temp) {
        int sum = temp[0] + temp[1];
        if (sum != 200) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
