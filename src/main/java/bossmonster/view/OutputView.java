package bossmonster.view;

import bossmonster.domain.AttackType;

public class OutputView {

    private static final String PRINT_BOSS_ATTACK_MESSAGE = "보스가 공격 했습니다. (입힌 데미지: %d)\n";
    private static final String PRINT_PLAYER_ATTACK_MESSAGE = " 공격을 했습니다." + "(입힌 데미지: %d)\n";

    public void printBossAttack(int damage) {
        System.out.printf(PRINT_BOSS_ATTACK_MESSAGE, damage);
    }

    public void printPlayerAttack(int damage, AttackType attackType) {
        System.out.printf(attackType.getMessage() + PRINT_PLAYER_ATTACK_MESSAGE, damage);
    }
}
