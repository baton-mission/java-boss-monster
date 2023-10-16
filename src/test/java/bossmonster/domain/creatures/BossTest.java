package bossmonster.domain.creatures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BossTest {
    @Test
    @DisplayName("보스 hp가 100 미만이면 예외가 발생한다.")
    void 보스_hp_100_미만() {
        assertThrows(IllegalArgumentException.class, () -> new Boss(99));
    }

    @Test
    @DisplayName("보스 hp가 300 초과면 예외가 발생한다.")
    void 보스_hp_300_초과() {
        assertThrows(IllegalArgumentException.class, () -> new Boss(301));
    }

    @ParameterizedTest
    @CsvSource(value = {"100", "200", "300"})
    @DisplayName("보스 체력이 100 ~ 300 사이라면 통과한다.")
    void BossTest(int input) {
        new Boss(input);
    }
}