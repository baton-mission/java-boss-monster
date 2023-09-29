package bossmonster.domain.bossmonster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("보스 몬스터 HP 기능 테스트")
class BossMonsterHpTest {

    @DisplayName("[성공 테스트] 유효한 범위의 HP 값으로 BossMonsterHp 생성자를 호출하면, BossMonsterHp 인스턴스가 생성된다.")
    @Test
    void 유효한_범위_HP_테스트() throws Exception {
        // Given
        int validHp = 200;

        // When
        BossMonsterHp createBossMonsterHp = new BossMonsterHp(validHp);

        // Then
        assertThat(createBossMonsterHp.getMaximumHp()).isEqualTo(validHp);
        assertThat(createBossMonsterHp.getCurrentHp()).isEqualTo(validHp);
    }

    @DisplayName("[예외 테스트] 유효범위보다 낮은 HP 값으로 BossMonsterHp 생성자를 호출하면, 예외가 발생한다.")
    @Test
    void 유효범위보다_낮은_HP_테스트() throws Exception {
        // Given
        int invalidHp = 50;

        // When
        Throwable throwable = catchThrowable(() -> new BossMonsterHp(invalidHp));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid Boss Monster HP");
    }

    @DisplayName("[예외 테스트] 유효범위보다 높은 HP 값으로 BossMonsterHp 생성자를 호출하면, 예외가 발생한다.")
    @Test
    void 유효범위보다_높은_HP_테스트() throws Exception {
        // Given
        int invalidHp = 1000;

        // When
        Throwable throwable = catchThrowable(() -> new BossMonsterHp(invalidHp));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid Boss Monster HP");
    }

    @DisplayName("[성공 테스트] 주어진 감소량 만큼, 현재 HP를 감소시킨다.")
    @Test
    void 현재_HP_감소_테스트() throws Exception {
        // Given
        int firstHp = 200;
        BossMonsterHp bossMonsterHp = setBossMonsterHp(firstHp);
        int decreaseHp = 128;

        // When
        bossMonsterHp.decreaseCurrentHp(decreaseHp);

        // Then
        assertThat(bossMonsterHp.getCurrentHp()).isEqualTo(firstHp - decreaseHp);
    }

    @DisplayName("[성공 테스트] 현재 HP가 0 이하라면 true를 반환한다.")
    @Test
    void 현재_HP가_0이하면_true_반환_검증_테스트() throws Exception {
        // Given
        int firstHp = 100;
        BossMonsterHp bossMonsterHp = setBossMonsterHp(firstHp);

        // When
        bossMonsterHp.decreaseCurrentHp(firstHp + 100);
        boolean currentHpZeroOrBelow = bossMonsterHp.isCurrentHpZeroOrBelow();

        // Then
        assertThat(currentHpZeroOrBelow).isTrue();
    }

    @DisplayName("[성공 테스트] 현재 HP가 0 이하가 아니라면 false를 반환한다.")
    @Test
    void 현재_HP가_0이하가_아니라면_false_반환_검증_테스트() throws Exception {
        // Given
        int firstHp = 100;
        BossMonsterHp bossMonsterHp = setBossMonsterHp(firstHp);

        // When
        boolean currentHpZeroOrBelow = bossMonsterHp.isCurrentHpZeroOrBelow();

        // Then
        assertThat(currentHpZeroOrBelow).isFalse();
    }

    private BossMonsterHp setBossMonsterHp(int hp) {
        return new BossMonsterHp(hp);
    }
}
