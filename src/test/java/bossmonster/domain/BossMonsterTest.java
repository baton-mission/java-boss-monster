package bossmonster.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BossMonsterTest {

    private final int PHYSICAL_ATTACK = 1;
    private final int MAGIC_ATTACK = 2;

    @DisplayName("보스 몬스터 HP 세팅 - 입력값 정상")
    @Test
    void setHp_with_correct_input() {
        // given
        final int hp = 200;

        // when
        BossMonster bossMonster = new BossMonster();
        bossMonster.setHp(hp);

        // then
        assertThat(bossMonster.getHp()).isEqualTo(200);
        assertThat(bossMonster.getMaxHp()).isEqualTo(200);
    }

    @DisplayName("보스 몬스터 HP 세팅 - 입력값 오류")
    @Test
    void setHp_with_wrong_input() {
        // given
        final int hp = 1;

        // when, then
        BossMonster bossMonster = new BossMonster();
        assertThatThrownBy(() -> bossMonster.setHp(hp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보스 몬스터가 플레이어 공격")
    @Test
    void attackPlayer() {
        // given
        Player player = new Player();
        BossMonster boss = new BossMonster();
        player.setStatus(100, 100);

        // when
        boss.attackPlayer(player);

        // then
        assertThat(player.getHp()).isLessThan(100);
    }

    @DisplayName("보스 몬스터가 공격 당함")
    @Test
    void attacked() {
        // given
        BossMonster boss = new BossMonster();
        AttackType attackType = new AttackType();
        boss.setHp(100);
        attackType.setType(PHYSICAL_ATTACK);

        // when
        boss.attacked(attackType);

        // then
        assertThat(boss.getHp()).isEqualTo(90);
    }

    @DisplayName("보스가 승리했는지 확인")
    @Test
    void isVictory() {
        // given
        Player player1 = new Player();
        Player player2 = new Player();
        BossMonster boss = new BossMonster();
        player1.setStatus(1, 199);
        player2.setStatus(100, 100);

        // when
        boss.attackPlayer(player1);
        boss.attackPlayer(player1);

        // then
        assertThat(boss.isVictory(player1)).isTrue();
        assertThat(boss.isVictory(player2)).isFalse();
    }
}