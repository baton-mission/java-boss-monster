package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InitialBossHpTest {


    @ParameterizedTest
    @ValueSource(ints = {99, 301})
    void from는_보스_체력이_될수있는_100_300_값이_아니면_예외를_응답한다(int initialBossHp) {
        assertThrows(IllegalArgumentException.class, () -> InitialBossHp.from(initialBossHp));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300})
    void from는_보스_체력이_될수있는_100_300_값이면_예외를_응답하지_않는다(int initialBossHp) {
        assertDoesNotThrow(() -> InitialBossHp.from(initialBossHp));
    }
}
