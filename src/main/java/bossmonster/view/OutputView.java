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
    private static final String BOSS_CLEAR_FORMAT = "%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.";
    private static final String GAME_OVER_FORMAT = "%s의 HP가 0이 되었습니다.\n보스 레이드에 실패했습니다.";
    private static final Object[] NORMAL_EMOJIS = {"0", "0", "\" ", "-"};
    private static final Object[] ATTACKED_EMOJIS = {"x", "x", "\"\\", "^"};
    private static final Object[] SMILE_EMOJIS = {"^", "^", "\" ", "3"};
    private static final int ZERO = 0;
    public static final String GAME_START = "보스 레이드를 시작합니다!";

    public void printBossAttack(int damage) {
        System.out.printf(BOSS_ATTACK_FORMAT, damage);
    }

    public void printPlayerAttack(int damage, AttackType attackType) {
        println();
        System.out.printf(attackType.getMessage() + PLAYER_ATTACK_FORMAT, damage);
    }

    public void printGameStatus(Player player, BossMonster bossMonster) {
        println();
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

    private void printGameOver(Player player) {
        System.out.printf(GAME_OVER_FORMAT, player.getName());
    }

    private void printBossClear(Player player, BossMonster bossMonster) {
        String name = player.getName();
        int attackedCount = bossMonster.getAttackedCount();
        System.out.printf(BOSS_CLEAR_FORMAT, name, attackedCount);
    }

    public void printGameResult(Player player, BossMonster bossMonster) {
        println();
        if (bossMonster.isDead()) {
            printBossClear(player, bossMonster);
            return;
        }
        if (player.isDead()) {
            printGameStatus(player, bossMonster, SMILE_EMOJIS);
            println();
            printGameOver(player);
        }
    }

    public void printGameStart() {
        println();
        System.out.println(GAME_START);
    }

    private void println() {
        System.out.println();
    }
}
