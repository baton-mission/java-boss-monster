package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InitialPlayerMpTest {


    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void from는_초기MP을_0보다_작은_값으로_할당하는_경우_예외가_발생한다(int initialPlayerMp) {
        assertThrows(IllegalArgumentException.class, () -> InitialPlayerMp.from(initialPlayerMp));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100, 200, 300})
    void from는_초기MP을_0이상의_값으로_할당하는_경우_예외가_발생하지_않는다(int initialPlayerMp) {
        assertDoesNotThrow(() -> InitialPlayerMp.from(initialPlayerMp));
    }


    @Test
    void plusWithHp는_초기MP와_플레이어_체력을_더한_값을_반환한다() {
        InitialPlayerMp initialPlayerMp = InitialPlayerMp.from(10);
        int playerHp = 10;
        int expectedTotal = 20;

        int actualTotal = initialPlayerMp.plusWithHp(playerHp);

        assertEquals(expectedTotal, actualTotal);
    }


    @Test
    void getNormalizedPlayerMp는_플레이어_마나가_초기_마나보다_큰_경우_초기_마나를_반환한다() {
        InitialPlayerMp initialPlayerMp = InitialPlayerMp.from(10);
        int effectedCurrentPlayerMp = 20;
        int expectedPlayerMp = 10;

        int actualPlayerMp = initialPlayerMp.getNormalizedPlayerMp(effectedCurrentPlayerMp);

        assertEquals(expectedPlayerMp, actualPlayerMp);
    }

    @Test
    void getNormalizedPlayerMp는_플레이어_마나가_초기_마나보다_작거나_같은_경우_플레이어_마나를_반환한다() {
        InitialPlayerMp initialPlayerMp = InitialPlayerMp.from(100);
        int effectedCurrentPlayerMp = 50;
        int expectedPlayerMp = 50;

        int actualPlayerMp = initialPlayerMp.getNormalizedPlayerMp(effectedCurrentPlayerMp);

        assertEquals(expectedPlayerMp, actualPlayerMp);
    }
}
