package bossmonster.view;

import bossmonster.dto.BattleInfoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameView {

    final int BOSS_NORMAL = 0;
    final int BOSS_DAMAGED = 1;
    final int BOSS_WIN = 2;

    Scanner scanner = new Scanner(System.in);

    public int printBossHpSettingView() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        int bossHp = Integer.valueOf(scanner.nextLine());
        return bossHp;
    }

    public String printPlayerNameSettingView() {
        System.out.println("플레이어의 이름을 입력해주세요.");
        String playerName = scanner.nextLine();
        return playerName;
    }

    public List<Integer> printPlayerStatusSettingView() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.");
        String inputString = scanner.nextLine();
        System.out.println("\n보스 레이드를 시작합니다!");
        return parseToIntegerList(inputString);
    }

    public int printPlayerPhaseView(BattleInfoDto battleInfoDto, int turnCount) {
        printBattleInfoView(battleInfoDto, turnCount);
        System.out.println("어떤 공격을 하시겠습니까?");
        System.out.println("1. 물리 공격");
        System.out.println("2. 마법 공격");

        int attackType = Integer.parseInt(scanner.nextLine());
        if (attackType == 1) {
            System.out.println("물리 공격을 했습니다. (입힌 대미지: 10)");
        }

        if (attackType == 2) {
            System.out.println("마법 공격을 했습니다. (입힌 대미지: 20)");
        }

        return attackType;
    }

    public void printBossPhaseView(int bossDamage) {
        System.out.println("보스가 공격했습니다. (입힌 대미지: " + bossDamage + ")");
    }

    public void printEndGameByVictoryView(BattleInfoDto battleInfoDto, int turnCount) {
        System.out.println(battleInfoDto.getPlayerName() + " 님이 " + turnCount + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
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
            System.out.println("  ^-^\n / 0 0 \\\n(   \"   )\n \\  -  /\n  - ^ -");
        }

        if (bossCondition == BOSS_DAMAGED) {
            System.out.println("  ^-^\n / x x \\\n(   \"   )\n \\  -  /\n  - ^ -");

        }

        if (bossCondition == BOSS_WIN) {
            System.out.println("  ^-^\n / ^ ^ \\\n(   \"   )\n \\  -  /\n  - ^ -");

        }
    }

    private List<Integer> parseToIntegerList(String inputString) {
        String[] inputStringArray = inputString.split(",");
        int playerHp = Integer.parseInt(inputStringArray[0]);
        int playerMp = Integer.parseInt(inputStringArray[1]);
        List<Integer> status = new ArrayList<>();
        status.add(playerHp);
        status.add(playerMp);

        return status;
    }
}
