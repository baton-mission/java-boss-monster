package bossmonster.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @CsvSource({
            "a, 1, 199",
            "user1, 200, 0"
    })
    void 플레이어_생성_성공(String name, int hp, int mp) {
        Player player = new Player(name, hp, mp);

        assertThat(player.getName()).isEqualTo(name);
        assertThat(player.getHp()).isEqualTo(hp);
        assertThat(player.getMp()).isEqualTo(mp);
    }

    @Nested
    class 플레이어_생성_실패 {

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "user12"})
        void 이름이_비어있거나_5_글자_이상이면_에러가_발생한다(String name) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player(name, 1, 199))
                    .withMessage(Player.INVALID_NAME_MASSAGE);
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 0})
        void HP가_1보다_작으면_에러가_발생한다(int hp) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player("user1", hp, 200 - hp))
                    .withMessage(Player.INVALID_HP_MESSAGE);
        }

        @Test
        void MP가_0보다_작으면_에러가_발생한다() {
            int mp = -1;

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player("user1", 200 - mp, mp))
                    .withMessage(Player.INVALID_MP_MESSAGE);
        }

        @ParameterizedTest
        @CsvSource({
                "1, 0",
                "1, 198",
                "1, 200"
        })
        void HP와_MP_합이_200이_아니면_에러가_발생한다(int hp, int mp) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player("user1", hp, mp))
                    .withMessage(Player.INVALID_STAT_MESSAGE);
        }
    }
}
