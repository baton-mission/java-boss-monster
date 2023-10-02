package bossmonster.view;

import java.util.List;
import java.util.Scanner;

import bossmonster.dto.request.AttackTypeCodeDto;
import bossmonster.dto.request.BossHpDto;
import bossmonster.dto.request.PlayerNameDto;
import bossmonster.dto.request.PlayerStatusInfoDto;
import bossmonster.dto.response.AttackTypeDto;
import bossmonster.util.InputConverter;
import bossmonster.util.InputValidator;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BOSS_HP_MESSAGE = "보스 몬스터의 HP를 입력해주세요.";
    private static final String PLAYER_NAME_MESSAGE = "플레이어의 이름을 입력해주세요.";
    private static final String PLAYER_HP_AND_MP_MESSAGE = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";
    private static final String ATTACK_TYPE_MESSAGE = "어떤 공격을 하시겠습니까?";
    private static final String ATTACK_TYPE_FORMAT = "%d. %s\n";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public BossHpDto scanBossHp() {
        System.out.println(BOSS_HP_MESSAGE);
        String rawBossHp = SCANNER.nextLine();
        printEmptyLine();
        InputValidator.validateBossHp(rawBossHp);
        int bossHp = InputConverter.convertBossHp(rawBossHp);
        return new BossHpDto(bossHp);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public PlayerNameDto scanPlayerNames() {
        System.out.println(PLAYER_NAME_MESSAGE);
        String rawPlayerName = SCANNER.nextLine();
        printEmptyLine();
        InputValidator.validatePlayerName(rawPlayerName);
        return new PlayerNameDto(rawPlayerName);
    }

    public PlayerStatusInfoDto scanPlayerHpAndMp() {
        System.out.println(PLAYER_HP_AND_MP_MESSAGE);
        String rawPlayerHpAndMp = SCANNER.nextLine();
        printEmptyLine();
        InputValidator.validatePlayerHpAndMp(rawPlayerHpAndMp);
        List<Integer> PlayerHpAndMp = InputConverter.convertPlayerHpAndMp(rawPlayerHpAndMp);
        return new PlayerStatusInfoDto(PlayerHpAndMp);
    }

    public AttackTypeCodeDto scanAttackType(AttackTypeDto attackTypeDto) {
        System.out.println(ATTACK_TYPE_MESSAGE);
        attackTypeDto.getAttackTypeMap().forEach((key, value) -> System.out.printf(ATTACK_TYPE_FORMAT, key, value));
        String rawAttackType = SCANNER.nextLine();
        printEmptyLine();
        InputValidator.validateAttackType(rawAttackType);
        int attackTypeCode = InputConverter.convertAttackTypeCode(rawAttackType);
        return new AttackTypeCodeDto(attackTypeCode);
    }

    private static class LazyHolder {

        private static final InputView INSTANCE = new InputView();

    }

}
