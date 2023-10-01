package bossmonster.domain.bossmonster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("보스 몬스터 HP 기능 테스트")
class BossMonsterHpTest {

    @DisplayName("[성공 테스트] 보스 몬스터 HP 설정 시, 유효한 범위의 값이 입력되면 인스턴스가 정상적으로 생성된다.")
    @Test
    void validate_hp_test() throws Exception {
        // Given
        int validateHp = 200;

        // When
        BossMonsterHp bossMonsterHp = new BossMonsterHp(validateHp);

        // Then
        assertThat(bossMonsterHp.getMaximumHp()).isEqualTo(validateHp);
        assertThat(bossMonsterHp.getCurrentHp()).isEqualTo(validateHp);
    }

    @DisplayName("[예외 테스트] 보스 몬스터 HP 설정 시, 유효한 범위 보다 낮은 값이 입력되면 예외가 발생한다.")
    @Test
    void validate_lower_hp_test() throws Exception {
        // Given
        int invalidHp = 50;

        // When
        Throwable throwable = catchThrowable(() -> new BossMonsterHp(invalidHp));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid Boss Monster HP");
    }

    @DisplayName("[예외 테스트] 보스 몬스터 HP 설정 시, 유효한 범위 보다 높은 값이 입력되면 예외가 발생한다.")
    @Test
    void validate_higher_hp_test() throws Exception {
        // Given
        int invalidHp = 1000;

        // When
        Throwable throwable = catchThrowable(() -> new BossMonsterHp(invalidHp));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid Boss Monster HP");
    }

    @DisplayName("[성공 테스트] 주어진 감소량 만큼 현재 HP를 감소시킨다.")
    @Test
    void decrease_current_hp_test() throws Exception {
        // Given
        int firstHp = 200;
        BossMonsterHp bossMonsterHp = new BossMonsterHp(firstHp);
        int decreaseHp = 128;

        // When
        bossMonsterHp.decreaseCurrentHp(decreaseHp);

        // Then
        assertThat(bossMonsterHp.getCurrentHp()).isEqualTo(firstHp - decreaseHp);
    }

    @DisplayName("[성공 테스트] 현재 HP의 0 이하 여부를 조회시, 0 이하가 맞으면 true를 반환한다.")
    @Test
    void is_current_hp_zero_or_below_true() throws Exception {
        // Given
        int currentHp = 100;
        int bigDecreaseHp = 200;
        BossMonsterHp bossMonsterHp = new BossMonsterHp(currentHp);

        // When
        bossMonsterHp.decreaseCurrentHp(bigDecreaseHp);
        boolean currentHpZeroOrBelow = bossMonsterHp.isCurrentHpZeroOrBelow();

        // Then
        assertThat(currentHpZeroOrBelow).isTrue();
    }

    @DisplayName("[성공 테스트] 현재 HP의 0 이하 여부를 조회시, 0 이하가 아니면 false를 반환한다.")
    @Test
    void is_current_hp_zero_or_below_false() throws Exception {
        // Given
        int currentHp = 100;
        int smallDecreaseHp = 50;
        BossMonsterHp bossMonsterHp = new BossMonsterHp(currentHp);

        // When
        bossMonsterHp.decreaseCurrentHp(smallDecreaseHp);
        boolean currentHpZeroOrBelow = bossMonsterHp.isCurrentHpZeroOrBelow();

        // Then
        assertThat(currentHpZeroOrBelow).isFalse();
    }
}
