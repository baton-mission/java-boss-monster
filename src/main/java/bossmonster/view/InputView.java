package bossmonster.view;

import java.util.Scanner;

import bossmonster.dto.request.BossHpDto;
import bossmonster.util.InputConverter;
import bossmonster.util.InputValidator;

public enum InputView {
    INSTANCE;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BOSS_HP_MESSAGE = "보스 몬스터의 HP를 입력해주세요.";

    public BossHpDto scanBossHp() {
        System.out.println(BOSS_HP_MESSAGE);
        String rawBossHp = SCANNER.nextLine();
        InputValidator.validateBossHp(rawBossHp);
        int bossHp = InputConverter.convertBossHp(rawBossHp);
        return new BossHpDto(bossHp);
    }
}
