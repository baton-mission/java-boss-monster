package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BossHpTest {

    @ParameterizedTest
    @ValueSource(ints = {99, 301})
    void from는_범위에_맞지_않는_보스_체력을_입력받으면_예외를_발생시킨다(int bossHp) {
        assertThrows(IllegalArgumentException.class, () -> BossHp.from(bossHp));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 300})
    void from는_범위에_맞는_보스_체력을_입력하면_정상응답한다(int bossHp) {
        assertDoesNotThrow(() -> BossHp.from(bossHp));
    }

    @Test
    void attackedBy는_물리공격을_할_경우_보스_체력을_감소시킨다() {
        BossHp bossHp = BossHp.from(200);
        AttackType attackType = AttackType.PHYSICAL;

        bossHp.attackedBy(attackType);

        assertThat(bossHp.getBossHp()).isEqualTo(190);
    }

    @Test
    void attackedBy는_마법공격을_할_경우_보스_체력을_감소시킨다() {
        BossHp bossHp = BossHp.from(200);
        AttackType attackType = AttackType.MAGICAL;

        bossHp.attackedBy(attackType);

        assertThat(bossHp.getBossHp()).isEqualTo(180);
    }

    @Test
    void attackedBy는_공격을_해서_보스_체력이_0밑으로_떨어져도_보스_체력은_0이다() {
        BossHp bossHp = BossHp.from(100);
        AttackType attackType = AttackType.MAGICAL;

        IntStream.range(0, 10)
                .forEach(i -> bossHp.attackedBy(attackType));

        assertThat(bossHp.getBossHp()).isEqualTo(0);
    }

    @Test
    void isUnderZero는_보스_체력이_0이_아니면_false_응답한다() {
        BossHp bossHp = BossHp.from(100);

        assertThat(bossHp.isUnderZero()).isFalse();
    }

    @Test
    void isUnderZero는_보스_체력이_0이면_true_응답한다() {
        BossHp bossHp = BossHp.from(100);
        AttackType attackType = AttackType.MAGICAL;

        IntStream.range(0, 10)
                .forEach(i -> bossHp.attackedBy(attackType));

        assertThat(bossHp.isUnderZero()).isTrue();
    }
}
