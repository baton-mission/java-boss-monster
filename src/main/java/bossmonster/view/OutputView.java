package bossmonster.view;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class OutputView {
    private static final String STATUS_DELIMITER = "============================";
    private static final String BOSS_STATUS_FORMAT = "BOSS HP [%d/%d]\n";
    private static final String PLAYER_STATUS_FORMAT = "dori HP [%d/%d] MP [%d/%d]\n";
    private static final String BOSS_FACE_FORMAT = """
            ____________________________
               ^-^
             / %s %s \\
            (   %s  )
             \\  %s  /
              - ^ -
            ____________________________
            """;
    private static final String BOSS_ATTACK_FORMAT = "보스가 공격 했습니다. (입힌 데미지: %d)\n";
    private static final String PLAYER_ATTACK_FORMAT = " 공격을 했습니다." + "(입힌 데미지: %d)\n";
    private static final Object[] NORMAL_EMOJIS = {"0", "0", "\" ", "-"};
    private static final Object[] ATTACKED_EMOJIS = {"x", "x", "\"\\", "^"};
    private static final int ZERO = 0;

    public void printBossAttack(int damage) {
        System.out.printf(BOSS_ATTACK_FORMAT, damage);
    }

    public void printPlayerAttack(int damage, AttackType attackType) {
        System.out.printf(attackType.getMessage() + PLAYER_ATTACK_FORMAT, damage);
    }

    public void printGameStatus(Player player, BossMonster bossMonster) {
        if (bossMonster.getAttackedCount() > ZERO) {
            printGameStatus(player, bossMonster, ATTACKED_EMOJIS);
            return;
        }
        printGameStatus(player, bossMonster, NORMAL_EMOJIS);
    }

    private void printGameStatus(Player player, BossMonster bossMonster, Object[] emojis) {
        System.out.println(STATUS_DELIMITER);
        printBossStatus(bossMonster);
        printBossFace(emojis);
        printPlayerStatus(player);
        System.out.println(STATUS_DELIMITER);
    }

    private void printBossStatus(BossMonster bossMonster) {
        int bossMonsterCurrentHp = bossMonster.getHp().getCurrentEnergy();
        int bossMonsterMaxHp = bossMonster.getHp().getMaxEnergy();
        System.out.printf(BOSS_STATUS_FORMAT, bossMonsterCurrentHp, bossMonsterMaxHp);
    }

    private void printBossFace(Object[] emojis) {
        System.out.printf(BOSS_FACE_FORMAT, emojis);
    }

    private void printPlayerStatus(Player player) {
        int playerCurrentHp = player.getHp().getCurrentEnergy();
        int playerMaxHp = player.getHp().getMaxEnergy();
        int playerCurrentMp = player.getMp().getMaxEnergy();
        int playerMaxMp = player.getMp().getMaxEnergy();
        System.out.printf(PLAYER_STATUS_FORMAT, playerCurrentHp, playerMaxHp, playerCurrentMp, playerMaxMp);
    }
}
