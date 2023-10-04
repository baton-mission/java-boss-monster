package bossmonster.domain;

import bossmonster.domain.attacktype.AttackType;
import bossmonster.domain.attacktype.MagicalAttack;
import bossmonster.domain.attacktype.PhysicalAttack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BossMonsterTest {

    private final int BOSS_DAMAGED = 101;

    @DisplayName("보스 몬스터 HP 세팅 - 입력값 정상")
    @ParameterizedTest
    @CsvSource(value = {"100, 100, 100", "200, 100, 200", "300, 100, 300"})
    void setHp_with_correct_input(int hp, int expectedCondition, int expectedHp) {
        BossMonster bossMonster = new BossMonster(hp);

        assertThat(bossMonster.getHp()).isEqualTo(expectedHp);
        assertThat(bossMonster.getMaxHp()).isEqualTo(expectedHp);
        assertThat(bossMonster.getCondition()).isEqualTo(expectedCondition);
    }

    @DisplayName("보스 몬스터 HP 세팅 - 입력값 오류")
    @ParameterizedTest
    @ValueSource(strings = {"1", "99", "301", "500"})
    void setHp_with_wrong_input(int hp) {
        assertThatThrownBy(() -> new BossMonster(hp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보스 몬스터가 플레이어 공격")
    @Test
    void attackPlayer() {
        // given
        Player player = new Player("test", 100, 100);
        BossMonster boss = new BossMonster(100);

        // when
        boss.attackPlayer(player);

        // then
        assertThat(player.getHp()).isLessThan(100);
    }

    @DisplayName("보스 몬스터가 공격 당함")
    @Test
    void attacked() {
        // given
        BossMonster boss1 = new BossMonster(100);
        BossMonster boss2 = new BossMonster(100);
        AttackType attackType1 = new PhysicalAttack();
        AttackType attackType2 = new MagicalAttack();

        // when
        boss1.attacked(attackType1);
        boss2.attacked(attackType2);

        // then
        assertThat(boss1.getHp()).isEqualTo(90);
        assertThat(boss1.getCondition()).isEqualTo(BOSS_DAMAGED);
        assertThat(boss2.getHp()).isEqualTo(80);
        assertThat(boss2.getCondition()).isEqualTo(BOSS_DAMAGED);
    }

    @DisplayName("보스가 죽었는지 확인")
    @Test
    void isDead() {
        // given
        BossMonster boss1 = new BossMonster(100);
        BossMonster boss2 = new BossMonster(100);
        AttackType attackType = new MagicalAttack();

        // when
        boss1.attacked(attackType);
        for (int i = 0; i < 5; i++) {
            boss2.attacked(attackType);
        }

        // then
        assertThat(boss1.isDead()).isFalse();
        assertThat(boss2.isDead()).isTrue();
    }
}