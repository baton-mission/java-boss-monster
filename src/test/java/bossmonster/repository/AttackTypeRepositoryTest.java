package bossmonster.repository;

import bossmonster.domain.attacktype.AttackType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AttackTypeRepositoryTest {

    AttackTypeRepository attackTypeRepository = new AttackTypeRepository();

    @DisplayName("공격 종류 얻기 - 입력값 정상")
    @ParameterizedTest
    @CsvSource(value = {"1, 1, 10, 10", "2, 2, 20, -30"})
    void getAttackType_with_correct_input(int inputTypeNum, int expectedTypeNum, int expectedDamage, int expectedMpChange) {
        AttackType attackType = attackTypeRepository.getAttackType(inputTypeNum);

        assertThat(attackType.getTypeNum()).isEqualTo(expectedTypeNum);
        assertThat(attackType.getDamage()).isEqualTo(expectedDamage);
        assertThat(attackType.getMpChange()).isEqualTo(expectedMpChange);
    }

    @DisplayName("공격 종류 얻기 - 입력값 오류")
    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "10"})
    void getAttackType_with_wrong_input(int inputTypeNum) {
        assertThatThrownBy(() -> attackTypeRepository.getAttackType(inputTypeNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}