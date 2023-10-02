package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class BossGameTest {

    @Test
    void attackPlayerFromBoss는_보스가_죽은_경우_0을_리턴한다() {
        Boss boss = Boss.from(100, (min, max) -> 20);
        Player player = Player.from(PlayerName.from("test"), PlayerStatus.from(100, 100));
        BossGame bossGame = BossGame.init(boss, player);

        IntStream.range(0, 5)
                .forEach(i -> bossGame.attackToBossFromPlayer(AttackType.MAGICAL));

        int damage = bossGame.attackPlayerFromBoss();

        assertEquals(0, damage);
    }

}
