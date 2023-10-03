package bossmonster.monster;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bossmonster.domain.characterattributes.Hp;
import bossmonster.domain.characterattributes.Mp;
import bossmonster.domain.characterattributes.Name;
import bossmonster.domain.characterattributes.Stat;
import bossmonster.domain.monster.BossMonster;
import bossmonster.domain.monster.BossMonsterAppearance;
import bossmonster.domain.player.Player;
import bossmonster.service.Service;

class BossMonsterTest {

    Service service;

    @BeforeEach
    void injectService() {
        service = new Service();
    }

    @DisplayName("보스 몬스터를 생성 시 외형은 기본값을 가진다.")
    @Test
    void isAppearanceDefault_Success_ByGenerateBossMonster() {
        // when
        BossMonster bossMonster = service.generateBossMonster(100);

        // then
        assertThat(bossMonster.appearance()).isEqualTo(BossMonsterAppearance.DEFAULT.getAppearance());
    }

    @DisplayName("보스 몬스터 생성 시 HP는 입력한 HP와 같다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 200})
    void isHpSameWithInputHp_Success_ByGenerateBossMonster(int inputHp) {
        // when
        BossMonster bossMonster = service.generateBossMonster(inputHp);
        int bossMonsterHp = bossMonster.hpAndInitialHp().get(0);

        // then
        assertThat(bossMonsterHp).isEqualTo(inputHp);
    }

    @DisplayName("보스 몬스터 생성 시 HP가 지정된 최소 값보다 작은 경우 실패한다.")
    @Test
    void generateBossMonster_Fail_ByHpLessThanMinimum() {
        // when, then
        assertThatThrownBy(() -> service.generateBossMonster(40))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보스 몬스터 생성 시 HP가 지정된 최대 값보다 큰 경우 실패한다.")
    @Test
    void generateBossMonster_Fail_ByHpMoreThanMaximum() {
        // when, then
        assertThatThrownBy(() -> service.generateBossMonster(400))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보스 몬스터가 플레이어 공격 시 플레이어의 HP가 공격 데미지만큼 감소한다.")
    @Test
    void reducePlayerHp_Success_ByAttack() {
        // given
        Player player = service.generatePlayer("user", List.of(100, 100));
        BossMonster bossMonster = service.generateBossMonster(100);

        // when
        bossMonster.attack(15, player);

        // then
        assertThat(player.stat().get(0)).isEqualTo(85);
    }
}