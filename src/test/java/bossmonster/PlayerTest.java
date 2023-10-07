package bossmonster;

import bossmonster.domain.Name;
import bossmonster.domain.Player;
import bossmonster.domain.Status;
import bossmonster.util.ErrorMessage;
import org.junit.jupiter.api.Test;

import static bossmonster.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    void 정상_테스트() {
        //given
        Name name = new Name("name");
        Status status = new Status(new int[]{100, 100});

        //when
        Player player = new Player(name, status);

        //then
        assertThat(player.getName()).isEqualTo("name");
        assertThat(player.getHp()).isEqualTo(100);
        assertThat(player.getMp()).isEqualTo(100);
        assertThat(player.getInitialHp() + player.getInitialMp()).isEqualTo(200);
    }

    @Test
    void 공백_이름_예외() {

        //when & then
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY);
    }

    @Test
    void 이름_길이_예외() {
        //when & then
        assertThatThrownBy(() -> new Name("gahgabgbalk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MAX_LENGTH);
    }

    @Test
    void hp_mp_합_예외() {
        //given
        Name name = new Name("name");

        //when & then
        assertThatThrownBy(() -> new Status(new int[]{101, 100}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SUM_EXCEPTION);
    }
}
