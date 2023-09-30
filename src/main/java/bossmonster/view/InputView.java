package bossmonster.view;

import bossmonster.dto.BattleInfoDto;
import bossmonster.exception.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();
    OutputView outputView = new OutputView();

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

        try {
            validator.validatePlayerName(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPlayerName();
        }

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

        System.out.println("\n보스 레이드를 시작합니다!\n");
        return parseToIntegerList(inputString);
    }

    public int readAttackType(BattleInfoDto battleInfoDto) {
        System.out.println("어떤 공격을 하시겠습니까?");
        System.out.println("1. 물리 공격");
        System.out.println("2. 마법 공격");

        String inputString = scanner.nextLine();

        int attackType = validateAttackType(battleInfoDto, inputString);

        if (attackType == 1) {
            System.out.println("\n물리 공격을 했습니다. (입힌 대미지: 10)");
        }

        if (attackType == 2) {
            System.out.println("\n마법 공격을 했습니다. (입힌 대미지: 20)");
        }

        return attackType;
    }

    private int validateAttackType(BattleInfoDto battleInfoDto, String inputString) {
        try {
            validator.validateAttackType(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAttackType(battleInfoDto);
        }

        int attackType = Integer.parseInt(inputString);

        if (attackType == 2) {
            try {
                validator.validateMpConsume(battleInfoDto.getPlayerMp());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return readAttackType(battleInfoDto);
            }
        }

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
