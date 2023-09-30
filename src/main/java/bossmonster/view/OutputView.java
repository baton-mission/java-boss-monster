package bossmonster.view;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("보스 레이드를 시작합니다!");
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
