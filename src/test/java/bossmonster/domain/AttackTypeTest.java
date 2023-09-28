package bossmonster.domain;

import static bossmonster.domain.AttackType.MAGICAL;
import static bossmonster.domain.AttackType.PHYSICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AttackTypeTest {

    /**
     * public static AttackType fromCode(int attackTypeCode) {
     * return Stream.of(values())
     * .filter(attackType -> attackType.attackTypeCode == attackTypeCode)
     * .findFirst()
     * .orElseThrow(() -> new IllegalArgumentException(ATTACK_TYPE_EXCEPTION_MESSAGE));
     * }
     */
    @Test
    void fromCode는_존재하지_않는_공격_타입_코드를_입력받으면_예외를_발생시킨다() {
        int attackTypeCode = 3;

        assertThrows(IllegalArgumentException.class, () -> AttackType.fromCode(attackTypeCode));
    }

    @ParameterizedTest
    @MethodSource("fromCode")
    void fromCode는_존재하는_공격_타입_코드를_입력받으면_해당_공격_타입을_반환한다(int attackTypeCode, AttackType expectedAttackType) {
        AttackType attackType = AttackType.fromCode(attackTypeCode);

        assertEquals(expectedAttackType, attackType);
    }


    private static Stream<Arguments> fromCode() {
        return Stream.of(
                Arguments.of(1, PHYSICAL),
                Arguments.of(2, MAGICAL)
        );
    }


    /**
     * public int effectMp(int playerMp) {
     * return this.mpStatus.effect(playerMp);
     * }
     * <p>
     * public int attack(int bossHp) {
     * return bossHp - this.attackPower;
     * }
     */
    @Test
    void effectMp는_물리_공격_타입인_경우_playerMp를_증가시킨다() {
        int playerMp = 100;
        int expectedPlayerMp = 110;

        assertEquals(expectedPlayerMp, PHYSICAL.effectMp(playerMp));
    }

    @Test
    void effectMp는_마법_공격_타입인_경우_playerMp를_감소시킨다() {
        int playerMp = 100;
        int expectedPlayerMp = 70;

        assertEquals(expectedPlayerMp, MAGICAL.effectMp(playerMp));
    }


    @ParameterizedTest
    @MethodSource("attack")
    void attack는_공격을_통해_보스의_체력을_감소시킨다(AttackType attackType, int expectedBossHp) {
        int bossHp = 100;

        assertEquals(expectedBossHp, attackType.attack(bossHp));
    }

    private static Stream<Arguments> attack() {
        return Stream.of(
                Arguments.of(PHYSICAL, 90),
                Arguments.of(MAGICAL, 80)
        );
    }
}
