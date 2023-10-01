package bossmonster.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("플레이어 이름 기능 테스트")
class PlayerNameTest {
    @DisplayName("[성공 테스트] 플레이어 이름 설정 시, 유효한 문자열 값이 입력되면 인스턴스가 정상적으로 생성된다.")
    @Test
    void validate_player_name_test() throws Exception {
        // Given
        String validPlayerName = "edgar";

        // When
        PlayerName playerName = new PlayerName(validPlayerName);

        // Then
        assertThat(playerName.getPlayerName()).isEqualTo(validPlayerName);
    }

    @DisplayName("[예외 테스트] 플레이어 이름 설정 시, 유효하지 않은 문자열 값이 입력되면 예외가 발생한다.")
    @MethodSource
    @ParameterizedTest(name = "[{index}] \"{0}\"")
    void validate_player_name_exception_test(String invalidInput) throws Exception {
        // When
        Throwable throwable = catchThrowable(() -> new PlayerName(invalidInput));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 플레이어 이름입니다.");
    }

    static Stream<Arguments> validate_player_name_exception_test() {
        return Stream.of(
                arguments(""),
                arguments(" "),
                arguments("abcdefgdfefefefef")
        );
    }
}
