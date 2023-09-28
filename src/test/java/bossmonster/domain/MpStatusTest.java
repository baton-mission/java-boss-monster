package bossmonster.domain;

import static bossmonster.domain.MpStatus.RECOVERY;
import static bossmonster.domain.MpStatus.REDUCE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MpStatusTest {


    @Test
    void effect는_마법공격을_하는_경우_playerMp를_감소시킨다() {
        int playerMp = 100;
        int expectedPlayerMp = 70;

        assertEquals(expectedPlayerMp, REDUCE.effect(playerMp));
    }

    @Test
    void effect는_물리_공격을_하는_경우_playerMp를_증가시킨다() {
        int playerMp = 100;
        int expectedPlayerMp = 110;

        assertEquals(expectedPlayerMp, RECOVERY.effect(playerMp));
    }
}
