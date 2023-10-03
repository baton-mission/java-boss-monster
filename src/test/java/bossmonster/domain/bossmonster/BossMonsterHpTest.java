package bossmonster.domain.bossmonster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bossmonster.util.BossMonsterFixture.createBossMonsterHp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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

    @DisplayName("[예외 테스트] 보스 몬스터 HP 설정 시, 유효한 범위 보다 낮거나 높은 값이 입력되면 예외가 발생한다.")
    @Test
    void validate_lower_hp_test() throws Exception {
        // Given
        int soSmallHp = -100;
        int soBigHp = 1000;
        // When
        Throwable smallHpthrowable = catchThrowable(() -> new BossMonsterHp(soSmallHp));
        Throwable bigHpthrowable = catchThrowable(() -> new BossMonsterHp(soBigHp));

        // Then
        assertThat(smallHpthrowable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid Boss Monster HP");
        assertThat(bigHpthrowable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid Boss Monster HP");
    }

    @DisplayName("[성공 테스트] 주어진 감소량 만큼 현재 HP를 감소시킨다.")
    @Test
    void decrease_current_hp_test() throws Exception {
        // Given
        int firstHp = 200;
        BossMonsterHp bossMonsterHp = createBossMonsterHp(firstHp);
        int decreaseHp = 128;

        // When
        bossMonsterHp.decreaseCurrentHp(decreaseHp);

        // Then
        assertThat(bossMonsterHp.getCurrentHp()).isEqualTo(firstHp - decreaseHp);
    }

    @DisplayName("[성공 테스트] 현재 HP가 0 이하이면 true를 반환하고, 1 이상이면 false를 반환한다.")
    @Test
    void is_current_hp_zero_or_below_true() throws Exception {
        // Given
        int bossMonsterHP = 100;

        BossMonsterHp belowBossMonsterHp = createBossMonsterHp(bossMonsterHP);
        belowBossMonsterHp.decreaseCurrentHp(bossMonsterHP + 100);

        BossMonsterHp notBelowBossMonsterHp = createBossMonsterHp(bossMonsterHP);

        // When
        boolean belowBossMonsterHpResult = belowBossMonsterHp.isCurrentHpZeroOrBelow();
        boolean notBelowBossMonsterHpResult = notBelowBossMonsterHp.isCurrentHpZeroOrBelow();

        // Then
        assertThat(belowBossMonsterHpResult).isTrue();
        assertThat(notBelowBossMonsterHpResult).isFalse();
    }
}
