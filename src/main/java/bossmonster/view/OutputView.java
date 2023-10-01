package bossmonster.view;

import java.util.Map;

import bossmonster.dto.BossMonsterInfo;
import bossmonster.dto.PlayerInfo;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("보스 레이드를 시작합니다!");
    }

    public static void printBossMonsterInfo(BossMonsterInfo info) {
        System.out.printf("BOSS HP [%d/%d]\n", info.getHp(), info.getInitialHp());
        printThinBoundary();
        System.out.println(info.getAppearance());
        printThinBoundary();
    }

    private static void printThinBoundary() {
        System.out.println("____________________________");
    }

    public static void printPlayerInfo(PlayerInfo info) {
        System.out.printf("%s HP [%d/%d] MP [%d/%d]\n",
                info.getName(),
                info.getHp(),
                info.getInitialHp(),
                info.getMp(),
                info.getInitialMp());
    }

    public static void printBoldBoundary() {
        System.out.println("============================");
    }

    public static void printPlayerAttackResult(String attackName, int damage) {
        System.out.printf("%s을 했습니다. (입힌 데미지: %d)\n", attackName, damage);
    }

    public static void printBossMonsterAttackResult(int bossMonsterDamage) {
        System.out.printf("보스가 공격 했습니다. (입힌 데미지: %d)\n", bossMonsterDamage);
    }

    public static void printWinningMessage(PlayerInfo info, int numberOfTurns) {
        System.out.printf("%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.\n", info.getName(), numberOfTurns);
    }

    public static void printDefeatMessage(PlayerInfo info) {
        System.out.printf("%s의 HP가 %d이 되었습니다.\n", info.getName(), info.getHp());
        System.out.println("보스 레이드에 실패했습니다.");
    }
}
