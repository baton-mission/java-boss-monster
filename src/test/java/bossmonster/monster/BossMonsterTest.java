package bossmonster.monster;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bossmonster.Hp;
import bossmonster.Mp;
import bossmonster.Name;
import bossmonster.Stat;
import bossmonster.player.Player;

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

    @DisplayName("플레이어 공격 시 플레이어의 HP가 공격 데미지만큼 감소한다.")
    @Test
    void reducePlayerHp_Success_ByAttack() {
        // given
        Name name = new Name("jam");
        Hp playerHp = new Hp(100);
        Mp playerMp = new Mp(100);
        Player player = new Player(name, new Stat(playerHp, playerMp));

        BossMonster bossMonster = new BossMonster(new Hp(100));

        // when
        bossMonster.attack(15, player);

        // then
        assertThat(playerHp.getHp()).isEqualTo(85);
    }
}