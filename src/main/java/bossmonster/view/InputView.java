package bossmonster.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    private final String PREFIX = "[ERROR] ";

    private Scanner scanner = new Scanner(System.in);

    public int readBossMonsterHp() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        String bossHp = scanner.nextLine();

        try {
            validateDigit(bossHp);
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
            validatePlayerStatus(inputString);
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
            validateDigit(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAttackType();
        }

        int attackType = Integer.parseInt(inputString);

        return attackType;
    }

    private void validatePlayerStatus(String status) {
        StringTokenizer st = new StringTokenizer(status, ",");
        String hp = st.nextToken();

        if (!st.hasMoreTokens()) {
            throw new IllegalArgumentException(PREFIX + "HP와 MP를 콤마(,)로 구분하여 입력해주세요. (예: 100,100)");
        }

        String mp = st.nextToken();
        validateDigit(hp);
        validateDigit(mp);
    }

    private void validateDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PREFIX + "입력이 잘못되었습니다. 다시 입력해주세요.");
        }
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
