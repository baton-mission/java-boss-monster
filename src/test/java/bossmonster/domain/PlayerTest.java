package bossmonster.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @DisplayName("플레이어 초기 세팅 테스트")
    @Test
    void createPlayer() {
        // given
        final String name = "testName";
        final int hp = 150;
        final int mp = 50;
        List<Integer> status = new ArrayList<>();
        status.add(hp);
        status.add(mp);

        // when
        Player player = new Player(name, status);

        // then
        assertThat(player.name).isEqualTo("testName");
        assertThat(player.hp).isEqualTo(150);
        assertThat(player.mp).isEqualTo(50);
    }


}