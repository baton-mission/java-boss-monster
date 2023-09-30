package bossmonster.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    private final int PHYSICAL_ATTACK = 1;
    private final int MAGIC_ATTACK = 2;

    @DisplayName("플레이어 이름 세팅 - 입력값 정상")
    @Test
    void setName_with_correct_input() {
        // given
        final String name = "test";

        // when
        Player player = new Player();
        player.setName(name);

        // then
        assertThat(player.getName()).isEqualTo("test");
    }

    @DisplayName("플레이어 이름 세팅 - 입력값 오류")
    @Test
    void setName_with_wrong_input() {
        // given
        final String name = "testName";

        // when, then
        Player player = new Player();
        assertThatThrownBy(() -> player.setName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 HP, MP 세팅 - 입력값 정상")
    @Test
    void setStatus_with_correct_input() {
        // given
        final int hp = 150;
        final int mp = 50;

        // when
        Player player = new Player();
        player.setStatus(hp, mp);

        // then
        assertThat(player.getHp()).isEqualTo(150);
        assertThat(player.getMaxHp()).isEqualTo(150);
        assertThat(player.getMp()).isEqualTo(50);
        assertThat(player.getMaxMp()).isEqualTo(50);
    }

    @DisplayName("플레이어 HP, MP 세팅 - 입력값 오류")
    @Test
    void setStatus_with_wrong_input() {
        // given
        final int hp = 1000;
        final int mp = 500;

        // when, then
        Player player = new Player();
        assertThatThrownBy(() -> player.setStatus(hp, mp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 보스를 물리 공격 - 입력값 정상")
    @Test
    void attackBossMonsterByPhysicalAttack_with_correct_input() {
        // given
        Player player = new Player();
        BossMonster boss = new BossMonster();
        AttackType attackType = new AttackType();
        player.setStatus(100, 100);
        boss.setHp(100);
        attackType.setType(PHYSICAL_ATTACK);

        // when
        player.attackBossMonster(boss, attackType);

        // then
        assertThat(boss.getHp()).isEqualTo(90);
    }

    @DisplayName("플레이어가 보스를 마법 공격 - 입력값 정상")
    @Test
    void attackBossMonsterByMagicAttack_with_correct_input() {
        // given
        Player player = new Player();
        BossMonster boss = new BossMonster();
        AttackType attackType = new AttackType();
        player.setStatus(100, 100);
        boss.setHp(100);
        attackType.setType(MAGIC_ATTACK);

        // when
        player.attackBossMonster(boss, attackType);

        // then
        assertThat(player.getMp()).isEqualTo(70);
        assertThat(boss.getHp()).isEqualTo(80);
    }

    @DisplayName("플레이어가 보스를 마법 공격 - MP 부족")
    @Test
    void attackBossMonsterByPhysicalAttack_with_wrong_input() {
        // given
        Player player = new Player();
        BossMonster boss = new BossMonster();
        AttackType attackType = new AttackType();
        player.setStatus(190, 10);
        boss.setHp(100);
        attackType.setType(MAGIC_ATTACK);

        // when, then
        assertThatThrownBy(() -> player.attackBossMonster(boss, attackType))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 보스에게 공격당함")
    @Test
    void attacked() {
        // given
        Player player = new Player();
        player.setStatus(100, 100);

        // when
        player.attacked(10);

        // then
        assertThat(player.getHp()).isEqualTo(90);
    }

    @DisplayName("플레이어가 승리했는지 확인")
    @Test
    void isVictory() {
        // given
        Player player = new Player();
        BossMonster boss1 = new BossMonster();
        BossMonster boss2 = new BossMonster();
        AttackType attackType = new AttackType();
        boss1.setHp(100);
        boss2.setHp(100);
        attackType.setType(MAGIC_ATTACK);

        // when
        for (int i = 0; i < 5; i++) {
            boss1.attacked(attackType);
        }
        boss2.attacked(attackType);

        // then
        assertThat(player.isVictory(boss1)).isTrue();
        assertThat(player.isVictory(boss2)).isFalse();
    }
}