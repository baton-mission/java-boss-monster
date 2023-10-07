package bossmonster;

import bossmonster.domain.Boss;
import org.junit.jupiter.api.Test;

import static bossmonster.util.ErrorMessage.HP_RANGE;
import static bossmonster.util.ErrorMessage.NUMERIC;
import static org.assertj.core.api.Assertions.*;

public class BossTest {

    @Test
    void 정상_테스트() {
        //given
        String minBossHp = "100";
        String maxBossHp = "300";

        //when
        Boss minBoss = new Boss(minBossHp);
        Boss maxBoss = new Boss(maxBossHp);

        //then
        assertThat(minBoss.getHp()).isEqualTo(100);
        assertThat(maxBoss.getHp()).isEqualTo(300);
    }

    @Test
    void 문자_체력_예외() {
        //given
        String stringBossHp = "hp";

        //when & then
        assertThatThrownBy(() -> new Boss(stringBossHp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMERIC);
    }

    @Test
    void 최소_체력_예외() {
        //given
        String lowBossHp = "99";

        //when & then
        assertThatThrownBy(() -> new Boss(lowBossHp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HP_RANGE);
    }

    @Test
    void 최대_체력_예외() {
        //given
        String highBossHp = "301";

        //when & then
        assertThatThrownBy(() -> new Boss(highBossHp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HP_RANGE);
    }
}
