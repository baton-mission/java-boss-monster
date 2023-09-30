package bossmonster.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AttackTypeTest {

    private final int PHYSICAL_ATTACK = 1;
    private final int PHYSICAL_DAMAGE = 10;
    private final int PHYSICAL_MP_CHANGE = 10;
    private final int MAGIC_ATTACK = 2;
    private final int MAGIC_DAMAGE = 20;
    private final int MAGIC_MP_CHANGE = -30;

    @DisplayName("공격 종류 세팅 - 입력값 정상")
    @Test
    void setType_with_correct_input() {
        // given
        AttackType attackType1 = new AttackType();
        AttackType attackType2 = new AttackType();

        // when
        attackType1.setType(PHYSICAL_ATTACK);
        attackType2.setType(MAGIC_ATTACK);

        // then
        assertThat(attackType1.getTypeNum()).isEqualTo(PHYSICAL_ATTACK);
        assertThat(attackType1.getDamage()).isEqualTo(PHYSICAL_DAMAGE);
        assertThat(attackType1.getMpChange()).isEqualTo(PHYSICAL_MP_CHANGE);
        assertThat(attackType2.getTypeNum()).isEqualTo(MAGIC_ATTACK);
        assertThat(attackType2.getDamage()).isEqualTo(MAGIC_DAMAGE);
        assertThat(attackType2.getMpChange()).isEqualTo(MAGIC_MP_CHANGE);
    }

    @DisplayName("공격 종류 세팅 - 입력값 오류")
    @Test
    void setType_with_wrong_input() {
        // given
        AttackType attackType = new AttackType();

        // when, then
        assertThatThrownBy(() -> attackType.setType(10000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}