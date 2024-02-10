package bossmonster.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String BOSS_HP_REQUEST_MESSAGE = "보스 몬스터의 HP를 입력해주세요.";
    private static final String READ_BOSS_HP_RANGE_EXCEPTION_FORMAT = "[ERROR] Boss Monster의 HP 범위가 맞지 않습니다.";
    private static final String PLAYER_NAME_REQUEST_MESSAGE = "플레이어의 이름을 입력해주세요";
    private static final String READ_PLAYER_NAME_EXCEPTION_MESSAGE = "[ERROR] Player의 이름 길이가 잘못되었습니다.";
    private static final String PLAYER_INFO_REQUEST_MESSAGE = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";
    private static final String READ_PLAYER_INFO_EXCEPTION_MESSAGE = "플레이어의 HP와 MP의 정보 입력이 올바르지 않습니다.";

    public int readBossMonsterHp() {
        System.out.println(BOSS_HP_REQUEST_MESSAGE);
        final int bossMonsterHp = scanner.nextInt();
        scanner.nextLine(); //줄바꿈 문자 제거
        if(bossMonsterHp <100 || bossMonsterHp > 300){
            throw new IllegalArgumentException(READ_BOSS_HP_RANGE_EXCEPTION_FORMAT);
        }
        return bossMonsterHp;
    }

    public String readPlayerName() {
        System.out.println(PLAYER_NAME_REQUEST_MESSAGE);
        final String name = scanner.nextLine();
        if(name.isEmpty()||name.length()>5){
            throw new IllegalArgumentException(READ_PLAYER_NAME_EXCEPTION_MESSAGE);
        }
        return name;
    }

    public int[] readPlayerInfo() {
        System.out.println(PLAYER_INFO_REQUEST_MESSAGE);
        final String info = scanner.nextLine();
        int[] newInfo = transformPlayerInfo(info);
        if(!validatePlayerInfo(newInfo)){
            throw new IllegalArgumentException(READ_PLAYER_INFO_EXCEPTION_MESSAGE);
        }
        return newInfo;
    }

    private boolean validatePlayerInfo(int[] info) {
        return (0 <= info[0] && info[0] <= 200) && (0 <= info[1] && info[1] <= 200) && (info[0] + info[1] == 200);
    }

    private int[] transformPlayerInfo(String info){
        String[] temp = splitPlayerInfo(info);
        return Arrays.stream(temp)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    private String[] splitPlayerInfo(String info){
        return Arrays.stream(info.split(","))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
