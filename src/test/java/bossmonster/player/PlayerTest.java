package bossmonster.player;

import static bossmonster.domain.player.Attack.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import bossmonster.domain.characterattributes.Hp;
import bossmonster.domain.characterattributes.Mp;
import bossmonster.domain.characterattributes.Name;
import bossmonster.domain.characterattributes.Stat;
import bossmonster.domain.monster.BossMonster;
import bossmonster.domain.player.Attack;
import bossmonster.domain.player.Player;
import bossmonster.service.Service;

class PlayerTest {

    Service service;

    @BeforeEach
    void injectService() {
        service = new Service();
    }

    @DisplayName("플레이어 생성 시 플레이어 이름은 입력한 이름과 같다.")
    @ParameterizedTest
    @ValueSource(strings = {"user", "jam"})
    void isNameSameWithInputName_Success_ByGeneratePlayer(String inputName) {
        // when
        Player player = service.generatePlayer(inputName, List.of(100, 100));

        // then
        assertThat(player.name()).isEqualTo(inputName);
    }

    @DisplayName("플레이어 생성 시 이름이 지정된 최대 글자수보다 많을 경우 실패한다.")
    @Test
    void generatePlayer_Fail_ByNameLengthMoreThanMaximum() {
        // when, then
        assertThatThrownBy(() -> service.generatePlayer("player", List.of(100, 100)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 생성 시 초기 HP와 MP의 합이 지정된 값이 아닌 경우 실패한다.")
    @Test
    void generatePlayer_Fail_ByInvalidSumOfInitialHpAndMp() {
        // when, then
        assertThatThrownBy(() -> service.generatePlayer("user", List.of(100, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 보스 몬스터 공격 시 보스 몬스터의 HP가 공격 데미지만큼 감소한다.")
    @ParameterizedTest
    @CsvSource(value = {"MAGIC, 100", "PHYSICAL, 100"})
    void reduceBossMonsterHp_Success_ByAttack(Attack attack, int inputBossMonsterHp) {
        // given
        BossMonster bossMonster = service.generateBossMonster(100);
        Player player = service.generatePlayer("user", List.of(100, 100));

        // when
        player.attack(attack, bossMonster);
        int bossMonsterHp = bossMonster.hpAndInitialHp().get(0);

        // then
        assertThat(bossMonsterHp).isEqualTo(inputBossMonsterHp - attack.getDamage());
    }

    @DisplayName("플레이어가 공격 시 MP가 부족한 경우 실패한다.")
    @Test
    void attack_Fail_ByNotEnoughMp() {
        // given
        BossMonster bossMonster = service.generateBossMonster(100);
        Player player = service.generatePlayer("user", List.of(190, 10));

        // when, then
        assertThatThrownBy(() -> player.attack(MAGIC, bossMonster))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 공격 시 MP를 회복하는 경우 최대치 이상의 MP는 회복하지 않는다.")
    @Test
    void attack_Success_ByExceedMp() {
        // given
        BossMonster bossMonster = service.generateBossMonster(100);
        Player player = service.generatePlayer("user", List.of(100, 100));

        // when
        player.attack(PHYSICAL, bossMonster);
        int playerMp = player.stat().get(2);

        // then
        assertThat(playerMp).isEqualTo(100);
    }

    @DisplayName("플레이어가 공격 시 MP를 해당 공격의 MP 소모량만큼 소모한다.")
    @Test
    void consumeMp_Success_ByAttack() {
        // given
        BossMonster bossMonster = service.generateBossMonster(100);
        Player player = service.generatePlayer("user", List.of(100, 100));

        // when
        player.attack(MAGIC, bossMonster);
        int playerMp = player.stat().get(2);

        // then
        assertThat(playerMp).isEqualTo(70);
    }
}