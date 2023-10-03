package bossmonster.domain.bossmonster;

import bossmonster.domain.bossmonster.dto.BossMonsterInfo;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.dto.PlayerInfo;
import bossmonster.util.PlayerFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bossmonster.domain.bossmonster.constant.BossMonsterOption.BOSS_MONSTER_MAXIMUM_RANDOM_DAMAGE_LIMIT;
import static bossmonster.domain.bossmonster.constant.BossMonsterOption.BOSS_MONSTER_MINIMUM_RANDOM_DAMAGE_LIMIT;
import static bossmonster.util.BossMonsterFixture.createBossMonster;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("보스 몬스터 기능 테스트")
class BossMonsterTest {

    @DisplayName("[성공 테스트] 보스 몬스터 피격 시, 주어진 데미지 만큼 현재 HP가 감소한다.")
    @Test
    void takeDamage_test() throws Exception {
        // Given
        int firstHp = 200;
        int damage = 100;
        BossMonster bossMonster = createBossMonster(firstHp);

        // When
        bossMonster.takeDamage(damage);
        BossMonsterInfo bossMonsterInfo = bossMonster.getBossMonsterInfo();

        // Then
        assertThat(bossMonsterInfo.getCurrentBossMonsterHp()).isEqualTo(firstHp - damage);
    }

    @DisplayName("[성공 테스트] 보스 몬스터의 생존 여부를 조회 시, 현재 HP가 1 이상이면 true를 반환한다.")
    @Test
    void is_alive_true_test() throws Exception {
        // Given
        int currentHp = 200;
        BossMonster bossMonster = createBossMonster(currentHp);

        // When
        boolean alive = bossMonster.isAlive();

        // Then
        assertThat(alive).isTrue();
    }

    @DisplayName("[성공 테스트] 보스 몬스터의 생존 여부를 조회 시, 현재 HP가 0 이하이면 false를 반환한다.")
    @Test
    void is_alive_false_test() throws Exception {
        // Given
        int currentHp = 200;
        int damageHigherThanCurrentHp = 300;
        BossMonster bossMonster = createBossMonster(currentHp);

        // When
        bossMonster.takeDamage(damageHigherThanCurrentHp);
        boolean alive = bossMonster.isAlive();

        // Then
        assertThat(alive).isFalse();
    }

    @DisplayName("[성공 테스트] 보스 몬스터 정보 조회시, 보스 몬스터의 최대 HP & 현재 HP 정보가 담긴 객체를 반환한다.")
    @Test
    void get_boss_monster_info_test() throws Exception {
        // Given
        int firstHp = 200;
        int damage = 30;
        BossMonster bossMonster = createBossMonster(firstHp);

        // When
        bossMonster.takeDamage(damage);
        BossMonsterInfo bossMonsterInfo = bossMonster.getBossMonsterInfo();

        // Then
        assertThat(bossMonsterInfo.getMaximumBossMonsterHp()).isEqualTo(firstHp);
        assertThat(bossMonsterInfo.getCurrentBossMonsterHp()).isEqualTo(firstHp - damage);
    }

    @DisplayName("[성공 테스트] 보스 몬스터가 플레이어를 공격 시, 0 ~ 20 범위의 랜덤한 데미지 만큼 플레이어의 현재 HP를 감소시키고 입힌 데미지를 반환한다.")
    @Test
    void attack_player_test() throws Exception {
        // Given
        int playerFirstHp = 100;
        Player player = PlayerFixture.createPlayer(playerFirstHp);
        BossMonster bossMonster = createBossMonster();

        // When
        int attackDamage = bossMonster.attackPlayer(player);
        PlayerInfo playerInfo = player.getPlayerInfo();

        // Then
        assertThat(attackDamage)
                .isBetween(
                        BOSS_MONSTER_MINIMUM_RANDOM_DAMAGE_LIMIT,
                        BOSS_MONSTER_MAXIMUM_RANDOM_DAMAGE_LIMIT
                );
        assertThat(playerInfo.getPlayerCurrentHp())
                .isBetween(
                        playerFirstHp - BOSS_MONSTER_MAXIMUM_RANDOM_DAMAGE_LIMIT,
                        playerFirstHp - BOSS_MONSTER_MINIMUM_RANDOM_DAMAGE_LIMIT
                );
    }
}
