package bossmonster.view;

import bossmonster.domain.Boss;
import bossmonster.domain.GameStatus;
import bossmonster.domain.Player;

import static bossmonster.util.Constants.*;

public class OutputView {

    public void printSetting(Boss boss, Player player) {
        System.out.println(START_MESSAGE);
        System.out.printf(SETTING_FORMAT,
                boss.getHp(), boss.getInitialHp(),
                player.getName(),
                player.getHp(), player.getInitialHp(),
                player.getMp(), player.getInitialMp()
        );
    }

    public void printResult(Boss boss, Player player, GameStatus status) {
        System.out.printf(ATTACK_MESSAGE, status.getType(), status.getAttackDamage());
        System.out.printf(BOSS_ATTACK_MESSAGE, status.getBossDamage());
        System.out.printf(RESULT_FORMAT,
                boss.getHp(), boss.getInitialHp(),
                player.getName(),
                player.getHp(), player.getInitialHp(),
                player.getMp(), player.getInitialMp()
        );
    }

    public void printBossDie(Player player, GameStatus status) {
        System.out.printf(ATTACK_MESSAGE, status.getType(), status.getAttackDamage());
        System.out.printf(BOSS_DIE_MESSAGE, player.getName(), status.getTryCount());
    }

    public void printPlayerDie(Player player) {
        System.out.printf(ZERO_HP_MESSAGE, player.getName());
        System.out.println(FAIL_MESSAGE);
    }
}
