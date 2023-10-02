package bossmonster.view;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;

public class OutputView {

    private static final String RESULT_FORMAT =
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

    public void printSetting(Boss boss, Player player) {
        System.out.println("보스 레이드를 시작합니다!\n");
        System.out.printf(RESULT_FORMAT, boss.getHp(), boss.getHp(), player.getName(), player.getHp(), player.getHp(), player.getMp(), player.getMp());
    }
}
