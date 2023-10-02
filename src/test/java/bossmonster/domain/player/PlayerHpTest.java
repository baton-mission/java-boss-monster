package bossmonster.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bossmonster.util.PlayerFixture.createPlayerHp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("플레이어 HP 기능 테스트")
class PlayerHpTest {

    @DisplayName("[성공 테스트] 플레이어 HP 설정 시, 유효한 범위의 HP 값이 입력되면 성공적으로 인스턴스가 생성된다.")
    @Test
    void validate_HP_test() throws Exception {
        // Given
        int validHp = 100;

        // When
        PlayerHp playerHp = new PlayerHp(validHp);

        // Then
        assertThat(playerHp.getMaximumHp()).isEqualTo(validHp);
        assertThat(playerHp.getCurrentHp()).isEqualTo(validHp);
    }

    @DisplayName("[예외 테스트] 플레이어 HP 설정 시, 유효한 범위 밖 HP 값이 입력되면 예외가 발생한다.")
    @Test
    void validate_HP_exception_test() throws Exception {
        // Given
        int soSmallHp = -1;
        int soBigHp = 1000;

        // When
        Throwable smallHpThrowable = catchThrowable(() -> new PlayerHp(soSmallHp));
        Throwable bigHpThrowable = catchThrowable(() -> new PlayerHp(soBigHp));

        // Then
        assertThat(smallHpThrowable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 플레이어 HP입니다.");
        assertThat(bigHpThrowable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 플레이어 HP입니다.");
    }

    @DisplayName("[성공 테스트] 주어진 감소량 만큼 현재 HP를 감소시킨다. 이때 0 미만으로는 감소할 수 없다.")
    @Test
    void decrease_current_hp_test() throws Exception {
        // Given
        int firstHp = 100;
        int decreaseHp1 = 50;
        int decreaseHp2 = 150;

        PlayerHp playerHp1 = createPlayerHp(firstHp);
        PlayerHp playerHp2 = createPlayerHp(firstHp);

        // When
        playerHp1.decreaseCurrentHp(decreaseHp1);
        playerHp2.decreaseCurrentHp(decreaseHp2);

        // Then
        assertThat(playerHp1.getCurrentHp()).isEqualTo(firstHp - decreaseHp1);
        assertThat(playerHp2.getCurrentHp()).isNotEqualTo(firstHp - decreaseHp1);
        assertThat(playerHp2.getCurrentHp()).isEqualTo(0);
    }

    @DisplayName("[성공 테스트] 현재 HP가 0 이하이면 true를 반환하고, 1 이상이면 false를 반환한다.")
    @Test
    void is_current_hp_zero_or_below_test() throws Exception {
        // Given
        int playerHp = 100;

        PlayerHp belowPlayerHp = createPlayerHp(playerHp);
        // HP를 감소시켜 값 조정
        belowPlayerHp.decreaseCurrentHp(playerHp + 100);

        PlayerHp notBelowPlayerHp = createPlayerHp(playerHp);

        // When
        boolean belowPlayerHpResult = belowPlayerHp.isCurrentHpZeroOrBelow();
        boolean notBelowPlayerHpResult = notBelowPlayerHp.isCurrentHpZeroOrBelow();

        // Then
        assertThat(belowPlayerHpResult).isTrue();
        assertThat(notBelowPlayerHpResult).isFalse();
    }
}
