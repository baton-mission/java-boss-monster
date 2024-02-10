package bossmonster;

import static org.assertj.core.api.Assertions.assertThat;

import bossmonster.domain.BossMonster;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BossMonsterTest {

    @Test
//    @DisplayName("보스 몬스터 hp 저장 테스트")
    void storeBossMonsterHpTest(){
        final int hp = 200;

        BossMonster bossMonster = new BossMonster(hp);

        assertThat(bossMonster.getHp()).isEqualTo(200);
    }
}
