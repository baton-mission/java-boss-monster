package bossmonster.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("플레이어 이름 기능 테스트")
class PlayerNameTest {
    @DisplayName("[성공 테스트] PlayerName 인스턴스 생성 시 유효한 플레이어 이름을 전달하면, 인스턴스가 생성된다.")
    @Test
    void 유효한_플레이어_이름_객체_생성_테스트() throws Exception {
        // Given
        String validPlayerName = "edgar";

        // When
        PlayerName playerName = new PlayerName(validPlayerName);

        // Then
        assertThat(playerName.getPlayerName()).isEqualTo(validPlayerName);
    }

    @DisplayName("[예외 테스트] PlayerName 인스턴스 생성 시 빈 문자열을 전달하면, 예외가 발생한다.")
    @Test
    void 비어있는_플레이어_이름_객체_생성_테스트() throws Exception {
        // Given
        String emptyPlayerName = "";

        // When
        Throwable throwable = catchThrowable(() -> new PlayerName(emptyPlayerName));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 플레이어 이름입니다.");
    }

    @DisplayName("[예외 테스트] PlayerName 인스턴스 생성 시 허용 길이 보다 긴 문자열을 전달하면, 예외가 발생한다.")
    @Test
    void 허용_길이_보다_긴_플레이어_이름_객체_생성_테스트() throws Exception {
        // Given
        String tooLongPlayerName = "abcedefhijkejefffeefefef";

        // When
        Throwable throwable = catchThrowable(() -> new PlayerName(tooLongPlayerName));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 플레이어 이름입니다.");
    }
}
