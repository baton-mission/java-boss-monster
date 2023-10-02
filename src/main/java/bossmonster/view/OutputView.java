package bossmonster.view;

import bossmonster.domain.Boss;
import bossmonster.domain.GameStatus;
import bossmonster.domain.Player;

public class OutputView {

    private static final String SETTING_FORMAT =
            """
            ============================
            BOSS HP [%s/%s]
            ____________________________
               ^-^
             / 0 0 \\
            (   "   )
             \\  -  /
              - ^ -
            ____________________________
            %s HP [%s/%s] MP [%s/%s]
            ============================
                    
            """;

    private static final String RESULT_FORMAT =
            """
            ============================
            BOSS HP [%s/%s]
            ____________________________
               ^-^
             / X X \\
            (   "   )
             \\  -  /
              - ^ -
            ____________________________
            %s HP [%s/%s] MP [%s/%s]
            ============================
                    
            """;

    public void printSetting(Boss boss, Player player) {
        System.out.println("보스 레이드를 시작합니다!\n");
        System.out.printf(SETTING_FORMAT, boss.getHp(), boss.getHp(), player.getName(), player.getHp(), player.getHp(), player.getMp(), player.getMp());
    }

    public void printResult(Boss boss, Player player, GameStatus status) {
        System.out.printf("%s를 했습니다. (입힌 데미지: %s)\n", status.getType(), status.getAttackDamage());
        System.out.printf("보스가 공격 했습니다. (입힌 데미지: %s)\n", status.getBossDamage());
        System.out.printf(RESULT_FORMAT, boss.getHp(), boss.getInitialHp(), player.getName(), player.getHp(), player.getInitialHp(), player.getMp(), player.getInitialMp());
    }

    public void printBossDie(Player player, GameStatus status) {
        System.out.printf("%s을 했습니다. (입힌 데미지: %d)\n", status.getType(), status.getAttackDamage());
        System.out.printf("%s 님이 %s번의 전투 끝에 보스 몬스터를 잡았습니다.", player.getName(), status.getTryCount());
    }

    public void printPlayerDie(Player player) {
        System.out.println(player.getName() + "의 HP가 0이 되었습니다.");
        System.out.println("보스 레이드에 실패했습니다.");
    }
}
