package bossmonster.view;

import bossmonster.exception.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();

    public int readBossMonsterHp() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        String bossHp = scanner.nextLine();

        try {
            validator.validateBossStatus(bossHp);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBossMonsterHp();
        }

        return Integer.parseInt(bossHp);
    }

    public String readPlayerName() {
        System.out.println("플레이어의 이름을 입력해주세요.");
        String playerName = scanner.nextLine();

        return playerName;
    }

    public List<Integer> readPlayerHpAndMp() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.");
        String inputString = scanner.nextLine();

        try {
            validator.validatePlayerStatus(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPlayerHpAndMp();
        }

        return parseToIntegerList(inputString);
    }

    public int readAttackType() {
        System.out.println("어떤 공격을 하시겠습니까?");
        System.out.println("1. 물리 공격");
        System.out.println("2. 마법 공격");

        String inputString = scanner.nextLine();

        int attackType = validateAttackType(inputString);

        return attackType;
    }

    private int validateAttackType(String inputString) {
        try {
            validator.validateAttackType(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAttackType();
        }

        int attackType = Integer.parseInt(inputString);

        return attackType;
    }

    private List<Integer> parseToIntegerList(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        int playerHp = Integer.parseInt(stringTokenizer.nextToken());
        int playerMp = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> status = new ArrayList<>();
        status.add(playerHp);
        status.add(playerMp);

        return status;
    }
}
