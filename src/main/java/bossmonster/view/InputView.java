package bossmonster.view;

import java.util.Scanner;

public class InputView {
    private static final String INVALID_NAME_MASSAGE = "플레이어의 이름은 1글자 이상 5글자 이하여야 합니다.";
    private static final String READ_BOSS_MONSTER_HP_MESSAGE = "보스 몬스터의 HP를 입력해주세요.";
    private static final String READ_PLAYER_NAME = "플레이어의 이름을 입력해주세요";
    private static final String READ_PLAYER_HP_AND_MP = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";
    private static final String NOT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    private static final int PLAYER_STAT_SIZE = 2;
    private static final String INVALID_PLAYER_STAT_MESSAGE = "HP와 MP를 콤마(,)로 구분해 입력해주세요. (e.g. 10,190)";
    private static final String PLAYER_STAT_DELIMITER = ",";
    private static final int HP_INDEX = 0;
    private static final int MP_INDEX = 1;
    private static final String READ_ATTACK_TYPE_MESSAGE = """
            어떤 공격을 하시겠습니까?
            1. 물리 공격
            2. 마법 공격""";
    private static final int MAX_NAME_LENGTH = 5;
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readBossMonsterHp() {
        print(READ_BOSS_MONSTER_HP_MESSAGE);
        return parseInt(scanner.nextLine());
    }

    public String readPlayerName() {
        println();
        print(READ_PLAYER_NAME);
        String playerName = scanner.nextLine();
        validatePlayerName(playerName);
        return playerName;
    }

    private void validatePlayerName(String playerName) {
        if (playerName.isBlank() || playerName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_MASSAGE);
        }
    }

    public int readAttackType() {
        println();
        print(READ_ATTACK_TYPE_MESSAGE);
        return parseInt(scanner.nextLine());
    }

    public PlayerStatDto readPlayerStat() {
        println();
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

    private void print(String message) {
        System.out.println(message);
    }

    private void println() {
        System.out.println();
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
