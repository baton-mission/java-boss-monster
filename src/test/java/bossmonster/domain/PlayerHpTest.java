package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PlayerHpTest {


    @Test
    void plus는_플레이어_마나와_플레이어_체력을_더한_값을_반환한다() {
        PlayerHp playerHp = PlayerHp.from(10);
        PlayerMp playerMp = PlayerMp.from(10);
        int expected = 20;

        int actual = playerHp.plus(playerMp);

        assertEquals(expected, actual);
    }


}
