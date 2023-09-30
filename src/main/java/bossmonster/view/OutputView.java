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
        System.out.printf("%s HP [%d/%d] MP [%d/%d]", name, hp, initialHp, mp, initialMp);
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

    public static void printPlayerAttackResult(String name, int damage) {
        System.out.printf("%s을 했습니다. (입힌 데미지: %d)\n", name, damage);
    }

    public static void printBossMonsterAttackResult(int bossMonsterDamage) {
        System.out.printf("보스가 공격 했습니다. (입힌 데미지: %d)\n", bossMonsterDamage);
    }
}
