package bossmonster.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bossmonster.Hp;
import bossmonster.Mp;
import bossmonster.Name;
import bossmonster.Stat;

class PlayerTest {

    @DisplayName("플레이어 생성 시 이름의 길이가 유효하지 않은 경우 예외를 발생시킨다.")
    @Test
    void constructPlayer_Fail_ByInvalidName() {
        // given
        Name name = new Name("lengthIsOver");
        Stat stat = new Stat(new Hp(100), new Mp(100));

        // when, then
        assertThatThrownBy(() -> new Player(name, stat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 생성 시 초기 HP와 MP의 합이 유효하지 않은 경우 예외를 발생시킨다.")
    @Test
    void constructPlayer_Fail_ByInvalidSumOfInitialHpAndMp() {
        // given
        Name name = new Name("jam");
        Stat stat = new Stat(new Hp(40), new Mp(30));

        // when, then
        assertThatThrownBy(() -> new Player(name, stat))
                .isInstanceOf(IllegalArgumentException.class);
    }
}