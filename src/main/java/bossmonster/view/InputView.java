package bossmonster.view;

import java.util.Scanner;

public class InputView {
    public static final String READ_BOSS_MONSTER_HP_MESSAGE = "보스 몬스터의 HP를 입력해주세요.";
    public static final String READ_PLAYER_NAME = "플레이어의 이름을 입력해주세요";
    public static final String READ_PLAYER_HP_AND_MP = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";
    public static final String NOT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    public static final int PLAYER_STAT_SIZE = 2;
    public static final String INVALID_PLAYER_STAT_MESSAGE = "HP와 MP를 콤마(,)로 구분해 입력해주세요. (e.g. 10,190)";
    public static final String PLAYER_STAT_DELIMITER = ",";
    public static final int HP_INDEX = 0;
    public static final int MP_INDEX = 1;
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readBossMonsterHp() {
        print(READ_BOSS_MONSTER_HP_MESSAGE);
        return parseInt(scanner.nextLine());
    }

    public String readPlayerName() {
        print(READ_PLAYER_NAME);
        return scanner.nextLine();
    }

    public PlayerStatDto readPlayerStat() {
        print(READ_PLAYER_HP_AND_MP);
        String[] playerStat = scanner.nextLine().split(PLAYER_STAT_DELIMITER);
        validatePlayerStat(playerStat);
        int hp = parseInt(playerStat[HP_INDEX]);
        int mp = parseInt(playerStat[MP_INDEX]);
        return new PlayerStatDto(hp, mp);
    }

    private void validatePlayerStat(String[] playerStat) {
        if (playerStat.length != PLAYER_STAT_SIZE) {
            throw new IllegalArgumentException(INVALID_PLAYER_STAT_MESSAGE);
        }
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
