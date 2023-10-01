package bossmonster.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bossmonster.util.PlayerFixture.createPlayerMp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("플레이어 MP 기능 테스트")
class PlayerMpTest {

    @DisplayName("[성공 테스트] 플레이어 MP 설정 시, 유효한 범위의 MP 값이 입력되면 성공적으로 인스턴스가 생성된다.")
    @Test
    void validate_HP_test() throws Exception {
        // Given
        int validMp = 100;

        // When
        PlayerMp playerMp = new PlayerMp(validMp);

        // Then
        assertThat(playerMp.getMaximumMp()).isEqualTo(validMp);
        assertThat(playerMp.getCurrentMp()).isEqualTo(validMp);
    }

    @DisplayName("[예외 테스트] 플레이어 HP & MP 설정 시, 유효한 범위 밖 MP 값이 입력되면 예외가 발생한다.")
    @Test
    void validate_MP_exception_test() throws Exception {
        // Given
        int soSmallMp = -1;
        int soBigMp = 1000;

        // When
        Throwable smallMpThrowable = catchThrowable(() -> new PlayerMp(soSmallMp));
        Throwable bigMpThrowable = catchThrowable(() -> new PlayerMp(soBigMp));

        // Then
        assertThat(smallMpThrowable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 플레이어 MP입니다.");
        assertThat(bigMpThrowable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 플레이어 MP입니다.");
    }

    @DisplayName("[성공 테스트] 주어진 필요 MP량이 현재 MP 값 이하이면 true, 아니면 false를 반환한다.")
    @Test
    void has_enough_mp_for_attack_test() throws Exception {
        // Given
        int currentMp = 100;
        int smallNeedMp = 50;
        int bigNeedMp = 200;

        PlayerMp playerMp = createPlayerMp(currentMp);

        // When
        boolean checkForSmallNeedMp = playerMp.hasEnoughMpForAttack(smallNeedMp);
        boolean checkForBigNeedMp = playerMp.hasEnoughMpForAttack(bigNeedMp);

        // Then
        assertThat(checkForSmallNeedMp).isTrue();
        assertThat(checkForBigNeedMp).isFalse();
    }

    @DisplayName("[성공 테스트] 주어진 증가량 만큼 현재 MP를 증가 시킨다.")
    @Test
    void increase_current_mp_test() throws Exception {
        // Given
        int maximumMp = 100;
        int currentMp = 50;
        int increaseMp = 30;

        PlayerMp playerMp = createPlayerMp(maximumMp);
        playerMp.decreaseCurrentMp(maximumMp - currentMp);

        // When
        playerMp.increaseCurrentMp(increaseMp);

        // Then
        assertThat(playerMp.getCurrentMp()).isEqualTo(currentMp + increaseMp);
    }

    @DisplayName("[성공 테스트] 주어진 증가량 만큼 현재 MP를 증가 시킬 때, 최대 MP를 넘어서 증가할 수 없다.")
    @Test
    void increase_current_mp_not_over_maximum_test() throws Exception {
        // Given
        int maximumMp = 100;
        int currentMp = 50;
        int increaseMp = 100;

        PlayerMp playerMp = createPlayerMp(maximumMp);
        playerMp.decreaseCurrentMp(maximumMp - currentMp);

        // When
        playerMp.increaseCurrentMp(increaseMp);

        // Then
        assertThat(playerMp.getCurrentMp()).isNotEqualTo(currentMp + increaseMp);
        assertThat(playerMp.getCurrentMp()).isEqualTo(maximumMp);
    }

    @DisplayName("[성공 테스트] 주어진 소모량 만큼 현재 MP를 감소시킨다.")
    @Test
    void decrease_current_mp_test() throws Exception {
        // Given
        int firstMp = 100;
        int consumptionMp = 30;

        PlayerMp playerMp = createPlayerMp(firstMp);

        // When
        playerMp.decreaseCurrentMp(consumptionMp);

        // Then
        assertThat(playerMp.getCurrentMp()).isEqualTo(firstMp - consumptionMp);
    }
}
