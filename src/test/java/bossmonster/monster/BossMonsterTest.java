package bossmonster.monster;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bossmonster.Hp;

class BossMonsterTest {

    @DisplayName("보스 몬스터 생성 시 HP가 최소 값보다 작은 경우 예외를 발생시킨다.")
    @Test
    void constructBossMonster_Fail_ByHpLessThanMinimum() {
        // given
        Hp hp = new Hp(80);

        // when, then
        assertThatThrownBy(() -> new BossMonster(hp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보스 몬스터 생성 시 HP가 최대 값보다 큰 경우 예외를 발생시킨다.")
    @Test
    void constructBossMonster_Fail_ByHpGreaterThanMaximum() {
        // given
        Hp hp = new Hp(350);

        // when, then
        assertThatThrownBy(() -> new BossMonster(hp))
                .isInstanceOf(IllegalArgumentException.class);
    }
}