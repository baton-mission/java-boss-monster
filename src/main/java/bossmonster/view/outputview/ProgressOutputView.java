package bossmonster.view.outputview;

import bossmonster.domain.creatures.Boss;
import bossmonster.domain.creatures.Player;
import bossmonster.view.OutputView;

import java.util.Map;

import static bossmonster.controller.Parameter.*;
import static bossmonster.view.outputview.OutputWriter.*;

public final class ProgressOutputView implements OutputView {

    static {
        writeln("보스 레이드를 시작합니다!");
    }

    @Override
    public void show(Map<String, String> param, Map<String, Object> model) {
        writeln("============================");
        printBossStat((Boss) model.get(BOSS.getName()));
        printBossSprite((BossSprite) model.get(BOSS_SPRITE.getName()));
        printPlayerState((Player) model.get(PLAYER.getName()));
        writeln("============================");

        print();

    }

    private void printBossStat(Boss boss) {
        if (boss == null) {
            throw new IllegalArgumentException("[Error] Boss 예외 발생");
        }
        writeln("BOSS HP [" + boss.getHp() + "/" + boss.getTotalHp() + "]");
    }

    private void printBossSprite(BossSprite bossSprite) {
        if (bossSprite == null) {
            throw new IllegalArgumentException("[ERROR] BossSprite 예외 발생");
        }
        writeln("____________________________");
        writeln(bossSprite.getSprite());
        writeln("____________________________");
    }

    private void printPlayerState(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("[ERROR] player 예외 발생");
        }
        write(player.getName() + " ");
        write(" HP [" + player.getHp() + "/" + player.getTotalHp() + "]");
        writeln(" MP [" + player.getMp() + "/" + player.getTotalMp() + "]");
    }
}
