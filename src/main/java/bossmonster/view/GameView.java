package bossmonster.view;

import bossmonster.dto.BattleInfoDto;
import bossmonster.exception.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameView {

    final int BOSS_NORMAL = 0;
    final int BOSS_DAMAGED = 1;
    final int BOSS_WIN = 2;

    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();

    public int printBossHpSettingView() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        String bossHp = scanner.nextLine();

        try {
            validator.validateBossStatus(bossHp);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printBossHpSettingView();
        }

        return Integer.parseInt(bossHp);
    }

    public String printPlayerNameSettingView() {
        System.out.println("플레이어의 이름을 입력해주세요.");
        String playerName = scanner.nextLine();

        try {
            validator.validatePlayerName(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPlayerNameSettingView();
        }

        return playerName;
    }

    public List<Integer> printPlayerStatusSettingView() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.");
        String inputString = scanner.nextLine();

        try {
            validator.validatePlayerStatus(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPlayerStatusSettingView();
        }

        System.out.println("\n보스 레이드를 시작합니다!\n");
        return parseToIntegerList(inputString);
    }

    public int printPlayerPhaseView(BattleInfoDto battleInfoDto, int turnCount) {
        printBattleInfoView(battleInfoDto, turnCount);
        System.out.println("어떤 공격을 하시겠습니까?");
        System.out.println("1. 물리 공격");
        System.out.println("2. 마법 공격");

        String inputString = scanner.nextLine();

        int attackType = validateAttackType(battleInfoDto, turnCount, inputString);

        if (attackType == 1) {
            System.out.println("\n물리 공격을 했습니다. (입힌 대미지: 10)");
        }

        if (attackType == 2) {
            System.out.println("\n마법 공격을 했습니다. (입힌 대미지: 20)");
        }

        return attackType;
    }

    public void printBossPhaseView(int bossDamage) {
        System.out.println("보스가 공격했습니다. (입힌 대미지: " + bossDamage + ")\n");
    }

    public void printEndGameByVictoryView(BattleInfoDto battleInfoDto, int turnCount) {
        System.out.println("\n" + battleInfoDto.getPlayerName() + " 님이 " + turnCount + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
    }

    public void printEndGameByDefeatView(BattleInfoDto battleInfoDto, int turnCount) {
        printBattleInfoView(battleInfoDto, turnCount);
        System.out.println(battleInfoDto.getPlayerName() + "의 HP가 0이 되었습니다");
        System.out.println("보스 레이드에 실패했습니다.");
    }

    private void printBattleInfoView(BattleInfoDto battleInfoDto, int turnCount) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + battleInfoDto.getBossHp() + "/" + battleInfoDto.getBossMaxHp() + "]");
        System.out.println("____________________________");

        if (turnCount == 1) {
            printBossMonsterView(BOSS_NORMAL);
        }

        if (turnCount > 1 && battleInfoDto.getPlayerHp() > 0) {
            printBossMonsterView(BOSS_DAMAGED);
        }

        if (turnCount > 1 && battleInfoDto.getPlayerHp() == 0) {
            printBossMonsterView(BOSS_WIN);
        }

        System.out.println("____________________________");
        System.out.println(battleInfoDto.getPlayerName()
                + " HP [" + battleInfoDto.getPlayerHp() + "/" + battleInfoDto.getPlayerMaxHp()
                + "] MP [" + battleInfoDto.getPlayerMp() + "/" + battleInfoDto.getPlayerMaxMp() +"]");
        System.out.println("============================\n");
    }

    private void printBossMonsterView(int bossCondition) {
        if (bossCondition == BOSS_NORMAL) {
            System.out.println("   ^-^\n / 0 0 \\\n(   \"   )\n \\  -  /\n  - ^ -");
        }

        if (bossCondition == BOSS_DAMAGED) {
            System.out.println("   ^-^\n / x x \\\n(   \"   )\n \\  -  /\n  - ^ -");

        }

        if (bossCondition == BOSS_WIN) {
            System.out.println("   ^-^\n / ^ ^ \\\n(   \"   )\n \\  -  /\n  - ^ -");

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

    private int validateAttackType(BattleInfoDto battleInfoDto, int turnCount, String inputString) {
        try {
            validator.validateAttackType(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPlayerPhaseView(battleInfoDto, turnCount);
        }

        int attackType = Integer.parseInt(inputString);

        try {
            validator.validateMpConsume(battleInfoDto.getPlayerMp());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPlayerPhaseView(battleInfoDto, turnCount);
        }

        return attackType;
    }
}
