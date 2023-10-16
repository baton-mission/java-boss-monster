package bossmonster.view;

public class OutputView {

    public static final String PRINT_BOSS_ATTACK_MESSAGE = "보스가 공격 했습니다. (입힌 데미지: %d)\n";

    public void printBossAttack(int damage) {
        System.out.printf(PRINT_BOSS_ATTACK_MESSAGE, damage);
    }
}
