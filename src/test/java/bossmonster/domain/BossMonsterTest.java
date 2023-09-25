package bossmonster.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BossMonsterTest {

    @DisplayName("보스 몬스터 초기 세팅 테스트")
    @Test
    void createBossMonster() {
        // given
        final int hp = 200;

        // when
        BossMonster bossMonster = new BossMonster(hp);

        // then
        assertThat(bossMonster.hp).isEqualTo(200);
        assertThat(bossMonster.turnCount).isEqualTo(1);
    }

}