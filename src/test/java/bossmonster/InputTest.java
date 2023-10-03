package bossmonster;

import static org.assertj.core.api.Assertions.assertThat;

import bossmonster.validation.InputValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputTest {


    @DisplayName("기초 정보 입력 예외처리 테스트")
    @Nested
    class InputValueTest {
        @Test
        @DisplayName("보스 HP 입력 테스트: 숫자가 아닌 경우")
        void bossHPInputTest_NotNumber() {
            IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class
                    , () -> InputValidation.validBossHP("Non-Number"));

            assertThat(e.getMessage()).isEqualTo("[ERROR] 숫자를 입력해주세요.");
        }

        @Test
        @DisplayName("보스 HP 입력 테스트: 범위가 아닌 경우")
        void bossHPInputTest_overRange() {
            IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class
                    , () -> InputValidation.validBossHP("10"));

            assertThat(e.getMessage()).isEqualTo("[ERROR] 100 ~ 300 사이의 숫자를 입력해주세요.");
        }

        @Test
        @DisplayName("플레이어 HP MP 입력 테스트: 조건에 맞지 않은 경우")
        void PlayerHPMPInputTest_strangeInputString() {
            IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class
                    , () -> InputValidation.validPlayerHPAndMP("Test"));

            assertThat(e.getMessage()).isEqualTo("[ERROR] 숫자를 입력해주세요.");
        }

        @Test
        @DisplayName("플레이어 HP MP 입력 테스트: 합이 200이 아닌 경우")
        void PlayerHPMPInputTest_additionNot200() {
            IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class
                    , () -> InputValidation.validPlayerHPAndMP("200,200"));

            assertThat(e.getMessage()).isEqualTo("[ERROR] HP와 MP의 합이 200이 되도록 입력해주세요.");
        }

        @Test
        @DisplayName("플레이어 이름 입력 테스트: 5자 초과인 경우")
        void PlayerNameInputTest_over5() {
            IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class
                    , () -> InputValidation.validPlayerName("123456"));

            assertThat(e.getMessage()).isEqualTo("[ERROR] 5자 이하의 이름을 입력해주세요.");
        }

        @Test
        @DisplayName("플레이어 공격 입력 테스트: 1이나 2가 아닌 경우")
        void PlayerAttackInputTest_Not1or2() {
            IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class
                    , () -> InputValidation.validAttackMethod("3"));

            assertThat(e.getMessage()).isEqualTo("[ERROR] 1 혹은 2를 입력해주세요.");
        }
    }
}
