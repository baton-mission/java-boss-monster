package bossmonster.view;

import bossmonster.dto.BattleInfoDto;

import java.util.Scanner;

public class OutputView {

    final int BOSS_NORMAL = 0;
    final int BOSS_DAMAGED = 1;
    final int BOSS_WIN = 2;

    Scanner scanner = new Scanner(System.in);

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

    public void printBattleInfoView(BattleInfoDto battleInfoDto, int turnCount) {
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
}
