package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TurnCountTest {

    @Test
    void init는_내부_시도한_횟수를_0으로_초기화한다() {
        TurnCount init = TurnCount.init();

        assertThat(init).isEqualTo(TurnCount.fromTest(0));
    }

    @Test
    void increase는_시도횟수를_증가한다() {
        TurnCount turnCount = TurnCount.fromTest(0);

        TurnCount increasedTurnCount = turnCount.increase();

        assertThat(increasedTurnCount).isEqualTo(TurnCount.fromTest(1));
    }
}
