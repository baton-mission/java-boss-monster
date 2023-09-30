package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InitialPlayerHpTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    void from는_0이하의_정수값이_체력이_되는경우_예외가_발생한다(int initialPlayerHp) {
        assertThrows(IllegalArgumentException.class, () -> InitialPlayerHp.from(initialPlayerHp));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200})
    void from는_0이상의_정수값이_체력이_되는경우_예외가_발생하지_않는다(int initialPlayerHp) {
        assertDoesNotThrow(() -> InitialPlayerHp.from(initialPlayerHp));
    }
}
