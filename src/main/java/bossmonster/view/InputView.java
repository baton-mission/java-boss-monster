package bossmonster.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String BOSS_HP_REQUEST_MESSAGE = "보스 몬스터의 HP를 입력하세요.";
    private static final String READ_BOSS_HP_RANGE_EXCEPTION_FORMAT = "[ERROR] Boss Monster의 HP 범위가 맞지 않습니다.";

    public int readBossMonsterHp() {
        System.out.println(BOSS_HP_REQUEST_MESSAGE);
        final int bossMonsterHp = scanner.nextInt();
        if(bossMonsterHp <100 || bossMonsterHp > 300){
            throw new IllegalArgumentException(READ_BOSS_HP_RANGE_EXCEPTION_FORMAT);
        }
        return bossMonsterHp;
    }
}
