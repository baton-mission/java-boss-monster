package bossmonster.player;

import static bossmonster.domain.player.Attack.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bossmonster.domain.characterattributes.Hp;
import bossmonster.domain.characterattributes.Mp;
import bossmonster.domain.characterattributes.Name;
import bossmonster.domain.characterattributes.Stat;
import bossmonster.domain.monster.BossMonster;
import bossmonster.domain.player.Player;

class PlayerTest {

    @DisplayName("플레이어 생성 시 이름의 길이가 유효하지 않은 경우 예외를 발생시킨다.")
    @Test
    void constructPlayer_Fail_ByInvalidName() {
        // given
        Name name = new Name("lengthIsOver");
        Stat stat = new Stat(new Hp(100), new Mp(100));

        // when, then
        assertThatThrownBy(() -> new Player(name, stat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 생성 시 초기 HP와 MP의 합이 유효하지 않은 경우 예외를 발생시킨다.")
    @Test
    void constructPlayer_Fail_ByInvalidSumOfInitialHpAndMp() {
        // given
        Name name = new Name("jam");
        Stat stat = new Stat(new Hp(40), new Mp(30));

        // when, then
        assertThatThrownBy(() -> new Player(name, stat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 보스 몬스터를 공격 시 보스 몬스터의 HP는 공격 데미지만큼 감소한다.")
    @Test
    void reduceBossMonsterHp_Success_ByAttack() {
        // given
        Hp playerHp = new Hp(100);
        Mp playerMp = new Mp(100);
        Player player = new Player(new Name("jam"), new Stat(playerHp, playerMp));
        Hp bossMonsterHp = new Hp(200);
        BossMonster bossMonster = new BossMonster(bossMonsterHp);

        // when
        player.attack(MAGIC, bossMonster);

        // then
        assertThat(bossMonsterHp.getHp()).isEqualTo(180);
    }

    @DisplayName("공격 시 최대치 이상의 MP는 회복하지 않는다.")
    @Test
    void attack_Success_ByExceedMp() {
        // given
        Hp playerHp = new Hp(100);
        Mp playerMp = new Mp(100);
        Player player = new Player(new Name("jam"), new Stat(playerHp, playerMp));
        Hp bossMonsterHp = new Hp(200);
        BossMonster bossMonster = new BossMonster(bossMonsterHp);

        // when
        player.attack(PHYSICAL, bossMonster);

        // then
        assertThat(playerMp.getMp()).isEqualTo(100);
    }

    @DisplayName("공격 시 플레이어의 MP를 해당 공격의 MP 소모량만큼 소모한다. ")
    @Test
    void consumeMp_Success_ByAttack() {
        // given
        Hp playerHp = new Hp(100);
        Mp playerMp = new Mp(100);
        Player player = new Player(new Name("jam"), new Stat(playerHp, playerMp));
        Hp bossMonsterHp = new Hp(200);
        BossMonster bossMonster = new BossMonster(bossMonsterHp);

        // when
        player.attack(MAGIC, bossMonster);

        // then
        assertThat(playerMp.getMp()).isEqualTo(70);
    }

    @DisplayName("공격 시 MP가 부족한 경우 예외를 발생시킨다.")
    @Test
    void attack_Fail_ByNotEnoughMp() {
        // given
        Hp playerHp = new Hp(180);
        Mp playerMp = new Mp(20);
        Player player = new Player(new Name("jam"), new Stat(playerHp, playerMp));
        Hp bossMonsterHp = new Hp(200);
        BossMonster bossMonster = new BossMonster(bossMonsterHp);

        // when, then
        assertThatThrownBy(() -> player.attack(MAGIC, bossMonster))
                .isInstanceOf(IllegalArgumentException.class);
    }
}