package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameTest {


    @ParameterizedTest
    @ValueSource(strings = {"플레이어", "플레이어1", "플레이어2"})
    void from는_플레이어_이름의_길이가_5이하인_경우_객체를_정상적으로_생성한다(String playerName) {
        assertDoesNotThrow(() -> PlayerName.from(playerName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"플레이어123", "플레이어1234", "플레이어12345"})
    void from는_플레이어_이름의_길이가_범위에_벗어나는_경우_예외를_응답한다(String playerName) {
        assertThatThrownBy(() -> PlayerName.from(playerName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
