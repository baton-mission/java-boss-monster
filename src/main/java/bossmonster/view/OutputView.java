package bossmonster.view;

import java.util.Map;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("보스 레이드를 시작합니다!");
    }

    public static void printBossMonsterInfo(Map<String, Integer> info) {
        System.out.printf("BOSS HP [%d/%d]\n", info.get("hp"), info.get("initialHp"));
    }

    public static void printPlayerInfo(String name, Map<String, Integer> info) {
        Integer hp = info.get("hp");
        Integer mp = info.get("mp");
        Integer initialHp = info.get("initialHp");
        Integer initialMp = info.get("initialMp");
        System.out.printf("%s HP [%d/%d] MP [%d/%d]\n", name, hp, initialHp, mp, initialMp);
    }

    public static void printBossMonsterAppearance(String appearance) {
        System.out.println(appearance);
    }

    public static void printBoldBoundary() {
        System.out.println("============================");
    }

    public static void printThinBoundary() {
        System.out.println("____________________________");
    }

    public static void printPlayerAttackResult(String attackName, int damage) {
        System.out.printf("%s을 했습니다. (입힌 데미지: %d)\n", attackName, damage);
    }

    public static void printBossMonsterAttackResult(int bossMonsterDamage) {
        System.out.printf("보스가 공격 했습니다. (입힌 데미지: %d)\n", bossMonsterDamage);
    }

    public static void printWinningMessage(String name, int count) {
        System.out.printf("%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.\n", name, count);
    }

    public static void printDefeatMessage(String name) {
        System.out.printf("%s의 HP가 0이 되었습니다.\n", name);
        System.out.println("보스 레이드에 실패했습니다.");
    }
}
