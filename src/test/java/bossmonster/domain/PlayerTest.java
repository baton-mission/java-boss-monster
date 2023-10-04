package bossmonster.domain;

import bossmonster.domain.attacktype.AttackType;
import bossmonster.domain.attacktype.MagicalAttack;
import bossmonster.domain.attacktype.PhysicalAttack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    private final int PHYSICAL_ATTACK = 1;
    private final int MAGIC_ATTACK = 2;

    @DisplayName("플레이어 초기값 세팅 - 입력값 정상")
    @ParameterizedTest
    @CsvSource(value = {"a, 1, 199", "abc, 100, 100", "abcde, 200, 0"})
    void setName_with_correct_input(String name, int hp, int mp) {
        Player player = new Player(name, hp, mp);

        assertThat(player.getName()).isEqualTo(name);
        assertThat(player.getHp()).isEqualTo(hp);
        assertThat(player.getMaxHp()).isEqualTo(hp);
        assertThat(player.getMp()).isEqualTo(mp);
        assertThat(player.getMaxMp()).isEqualTo(mp);
    }

    @DisplayName("플레이어 이름 세팅 - 입력값 오류")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abcdef"})
    void setName_with_wrong_input(String name) {
        assertThatThrownBy(() -> new Player(name, 100, 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 HP,  MP 세팅 - 입력값 오류")
    @ParameterizedTest
    @CsvSource(value = {"0, 200", "50,50", "100, 101"})
    void setHpAndMp_with_wrong_input(int hp, int mp) {
        assertThatThrownBy(() -> new Player("test", hp, mp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 보스를 물리 공격 - 입력값 정상")
    @Test
    void attackBossMonsterByPhysicalAttack_with_correct_input() {
        // given
        Player player = new Player("test", 100, 100);
        BossMonster boss = new BossMonster(100);
        AttackType attackType = new PhysicalAttack();

        // when
        player.attackBossMonster(boss, attackType);

        // then
        assertThat(boss.getHp()).isEqualTo(90);
    }

    @DisplayName("플레이어가 보스를 마법 공격 - 입력값 정상")
    @Test
    void attackBossMonsterByMagicAttack_with_correct_input() {
        // given
        Player player = new Player("test", 100, 100);
        BossMonster boss = new BossMonster(100);
        AttackType attackType = new MagicalAttack();

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
        Player player = new Player("test", 190, 10);
        BossMonster boss = new BossMonster(100);
        AttackType attackType = new MagicalAttack();

        // when, then
        assertThatThrownBy(() -> player.attackBossMonster(boss, attackType))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 보스에게 공격당함")
    @Test
    void attacked() {
        // given
        Player player = new Player("test", 100, 100);

        // when
        player.attacked(10);

        // then
        assertThat(player.getHp()).isEqualTo(90);
    }

    @DisplayName("플레이어가 죽었는지 확인")
    @Test
    void isDead() {
        // given
        Player player1 = new Player("test", 1, 199);
        Player player2 = new Player("test", 100, 100);

        // when
        player1.attacked(10);
        player2.attacked(10);

        // then
        assertThat(player1.isDead()).isTrue();
        assertThat(player2.isDead()).isFalse();
    }
}