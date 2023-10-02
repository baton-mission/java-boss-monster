package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CurrentPlayerMpTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void from는_0이하의_정수값이_마나가_되는경우_예외가_발생한다(int currentPlayerMp) {
        assertThrows(IllegalArgumentException.class, () -> CurrentPlayerMp.from(currentPlayerMp));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100, 200, 300})
    void from는_0이상의_정수값이_마나가_되는경우_예외가_발생하지_않는다(int currentPlayerMp) {
        assertDoesNotThrow(() -> CurrentPlayerMp.from(currentPlayerMp));
    }


    @Test
    void effectMpByAttackType는_물리공격을_하는_경우_MP을_회복한다() {
        CurrentPlayerMp currentPlayerMp = CurrentPlayerMp.from(10);
        InitialPlayerMp initialPlayerMp = InitialPlayerMp.from(100);
        AttackType attackType = AttackType.PHYSICAL;
        CurrentPlayerMp expectedCurrentPlayerMp = CurrentPlayerMp.from(20);

        CurrentPlayerMp actualPlayerMp = currentPlayerMp.effectMpByAttackType(attackType, initialPlayerMp);

        assertEquals(expectedCurrentPlayerMp, actualPlayerMp);
    }

    @Test
    void effectMpByAttackType는_물리공격을_해서_MP을_회복하는_경우_최대치를_넘겨_회복하지_않는다() {
        CurrentPlayerMp currentPlayerMp = CurrentPlayerMp.from(100);
        InitialPlayerMp initialPlayerMp = InitialPlayerMp.from(100);
        AttackType attackType = AttackType.PHYSICAL;
        CurrentPlayerMp expectedCurrentPlayerMp = CurrentPlayerMp.from(100);

        CurrentPlayerMp actualPlayerMp = currentPlayerMp.effectMpByAttackType(attackType, initialPlayerMp);

        assertEquals(expectedCurrentPlayerMp, actualPlayerMp);
    }

    @Test
    void effectMpByAttackType는_마법공격을_하는_경우_MP을_소모한다() {
        CurrentPlayerMp currentPlayerMp = CurrentPlayerMp.from(30);
        InitialPlayerMp initialPlayerMp = InitialPlayerMp.from(100);
        AttackType attackType = AttackType.MAGICAL;
        CurrentPlayerMp expectedCurrentPlayerMp = CurrentPlayerMp.from(0);

        CurrentPlayerMp actualPlayerMp = currentPlayerMp.effectMpByAttackType(attackType, initialPlayerMp);

        assertEquals(expectedCurrentPlayerMp, actualPlayerMp);
    }

    @Test
    void effectMyByAttackType는_마법공격을_할_충분한_MP가_없는_경우_예외를_응답한다() {
        CurrentPlayerMp currentPlayerMp = CurrentPlayerMp.from(10);
        InitialPlayerMp initialPlayerMp = InitialPlayerMp.from(100);
        AttackType attackType = AttackType.MAGICAL;

        assertThrows(IllegalArgumentException.class, () -> currentPlayerMp.effectMpByAttackType(attackType, initialPlayerMp));
    }
}
