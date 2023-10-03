package bossmonster;

import bossmonster.domain.Player;
import org.junit.jupiter.api.Test;

import static bossmonster.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    private static final int HP_MP_SUM = 200;

    @Test
    void 정상_테스트() {
        //given
        String name = "name";
        int hp = 100;
        int mp = HP_MP_SUM - hp;

        //when
        Player player = new Player(name, hp, mp);

        //then
        assertThat(player.getName()).isEqualTo("name");
        assertThat(player.getHp()).isEqualTo(100);
        assertThat(player.getMp()).isEqualTo(100);
        assertThat(player.getInitialHp() + player.getInitialMp()).isEqualTo(200);
    }

    @Test
    void 공백_이름_예외() {
        //given
        String blank = "";
        int hp = 100;
        int mp = 100;

        //when & then
        assertThatThrownBy(() -> new Player(blank, hp, mp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY);
    }

    @Test
    void 이름_길이_예외() {
        //given
        String longName = "bfghjkakhbafjk";
        int hp = 100;
        int mp = 100;

        //when & then
        assertThatThrownBy(() -> new Player(longName, hp, mp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MAX_LENGTH);
    }

    @Test
    void hp_mp_합_예외() {
        //given
        String name = "name";
        int hp = 101;
        int mp = 100;

        //when & then
        assertThatThrownBy(() -> new Player(name, hp, mp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SUM);
    }
}
