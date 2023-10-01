package bossmonster.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("플레이어 HP & MP 기능 테스트")
class PlayerHpAndMpTest {
    @DisplayName("[성공 테스트] 플레이어 HP & MP 설정 시, 유효한 값이 입력되면 인스턴스가 정상적으로 생성된다.")
    @Test
    void validate_player_hp_and_mp_test() throws Exception {
        // Given
        int validPlayerHp = 100;
        int validPlayerMp = 100;

        // When
        PlayerHpAndMp playerHpAndMp = new PlayerHpAndMp(
                validPlayerHp,
                validPlayerMp
        );

        // Then
        assertThat(playerHpAndMp.getHp().getMaximumHp()).isEqualTo(validPlayerHp);
        assertThat(playerHpAndMp.getHp().getCurrentHp()).isEqualTo(validPlayerHp);
        assertThat(playerHpAndMp.getMp().getMaximumMp()).isEqualTo(validPlayerMp);
        assertThat(playerHpAndMp.getMp().getCurrentMp()).isEqualTo(validPlayerMp);
    }

    @DisplayName("[예외 테스트] 플레이어 HP & MP 설정 시, 입력된 HP와 MP의 합이 200이 아니라면, 예외가 발생한다.")
    @Test
    void validate_HP_and_MP_sum_exception_test() throws Exception {
        // Given
        int playerHp = 100;
        int playerMp = 50;

        // When
        Throwable throwable = catchThrowable(() -> new PlayerHpAndMp(playerHp, playerMp));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 HP와 MP의 합이 유효하지 않습니다.");
    }
}
