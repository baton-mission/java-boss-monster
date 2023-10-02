package bossmonster.domain.player;

import bossmonster.domain.bossmonster.BossMonster;
import bossmonster.domain.bossmonster.dto.BossMonsterInfo;
import bossmonster.domain.player.constant.PlayerAttackOption;
import bossmonster.domain.player.dto.PlayerInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bossmonster.domain.player.constant.PlayerAttackOption.MAGIC;
import static bossmonster.domain.player.constant.PlayerAttackOption.PHYSICAL;
import static bossmonster.util.BossMonsterFixture.createBossMonster;
import static bossmonster.util.PlayerFixture.createPlayer;
import static bossmonster.util.PlayerFixture.createPlayerMp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("플레이어 기능 테스트")
class PlayerTest {
    @DisplayName("[성공 테스트] 플레이어 피격 시, 주어진 데미지 만큼 현재 HP가 감소한다.")
    @Test
    void take_damage_test() throws Exception {
        // Given
        int firstHp = 100;
        int damage = 50;
        Player player = createPlayer(firstHp);

        // When
        player.takeDamage(damage);
        PlayerInfo playerInfo = player.getPlayerInfo();

        // Then
        assertThat(playerInfo.getPlayerCurrentHp()).isEqualTo(firstHp - damage);
    }

    @DisplayName("[성공 테스트] 플레이어의 생존 여부를 조회 시, 현재 HP가 1 이상이면 true를 반환한다.")
    @Test
    void is_alive_true_test() throws Exception {
        // Given
        int currentHp = 200;
        Player player = createPlayer(currentHp);

        // When
        boolean alive = player.isAlive();

        // Then
        assertThat(alive).isTrue();
    }

    @DisplayName("[성공 테스트] 플레이어의 생존 여부를 조회 시, 현재 HP가 0 이하이면 false를 반환한다.")
    @Test
    void is_alive_false_test() throws Exception {
        // Given
        int currentHp = 200;
        int damageHigherThanCurrentHp = 300;
        Player player = createPlayer(currentHp);

        // When
        player.takeDamage(damageHigherThanCurrentHp);
        boolean alive = player.isAlive();

        // Then
        assertThat(alive).isFalse();
    }

    @DisplayName("[성공 테스트] 플레이어 정보 조회시, 플레이어의 이름, 최대 HP & 현재 HP, 최대 MP & 현재 MP 정보가 담긴 객체를 반환한다.")
    @Test
    void get_player_info_test() throws Exception {
        // Given
        String playerName = "edgar";
        int playerHp = 100;
        int playerMp = 100;
        Player player = createPlayer(
                playerName,
                playerHp,
                playerMp
        );

        // When
        PlayerInfo playerInfo = player.getPlayerInfo();

        // Then
        assertThat(playerInfo.getPlayerName()).isEqualTo(playerName);
        assertThat(playerInfo.getPlayerMaximumHp()).isEqualTo(playerHp);
        assertThat(playerInfo.getPlayerCurrentHp()).isEqualTo(playerHp);
        assertThat(playerInfo.getPlayerMaximumMp()).isEqualTo(playerMp);
        assertThat(playerInfo.getPlayerCurrentMp()).isEqualTo(playerMp);
    }

    @DisplayName("[성공 테스트] 플레이어가 물리공격을 수행할 시, 보스 몬스터에게 10 데미지를 주고 자신의 현재 MP를 10 회복한다. 그리고 공격 데미지를 반환한다.")
    @Test
    void attack_boss_monster_physical_test() throws Exception {
        // Given
        int bossMonsterFirstHp = 200;
        int playerMaximumMp = 100;
        int playerFirstCurrentMp = 40;
        PlayerAttackOption physicalAttack = PHYSICAL;

        BossMonster bossMonster = createBossMonster(bossMonsterFirstHp);

        PlayerMp playerMp = createPlayerMp(playerMaximumMp);
        // MP 회복 테스트를 위해, 현재 MP 값 조정
        playerMp.decreaseCurrentMp(playerMaximumMp - playerFirstCurrentMp);
        Player player = createPlayer(playerMp);

        // When
        int attackDamage = player.attackBossMonster(
                bossMonster,
                physicalAttack
        );

        BossMonsterInfo bossMonsterInfo = bossMonster.getBossMonsterInfo();
        PlayerInfo playerInfo = player.getPlayerInfo();

        // Then
        assertThat(attackDamage).isEqualTo(physicalAttack.getDamage());
        assertThat(bossMonsterInfo.getCurrentBossMonsterHp()).isEqualTo(bossMonsterFirstHp - physicalAttack.getDamage());
        assertThat(playerInfo.getPlayerCurrentMp()).isEqualTo(playerFirstCurrentMp + physicalAttack.getRecoveryMp());
    }

    @DisplayName("[성공 테스트] 플레이어가 물리공격을 수행할 시, 보스 몬스터에게 10 데미지를 주고 자신의 현재 MP를 10 회복한다. 이때 최대 MP를 초과해서 회복할 수 없다.")
    @Test
    void attack_boss_monster_physical_not_over_maximum_hp_test() throws Exception {
        // Given
        int bossMonsterFirstHp = 200;
        int playerMaximumMp = 100;
        int playerFirstCurrentMp = 95;
        PlayerAttackOption physicalAttack = PHYSICAL;

        BossMonster bossMonster = createBossMonster(bossMonsterFirstHp);

        PlayerMp playerMp = createPlayerMp(playerMaximumMp);
        // MP 회복 테스트를 위해, 현재 MP 값 조정
        playerMp.decreaseCurrentMp(playerMaximumMp - playerFirstCurrentMp);
        Player player = createPlayer(playerMp);

        // When
        player.attackBossMonster(
                bossMonster,
                physicalAttack
        );

        BossMonsterInfo bossMonsterInfo = bossMonster.getBossMonsterInfo();
        PlayerInfo playerInfo = player.getPlayerInfo();

        // Then
        assertThat(bossMonsterInfo.getCurrentBossMonsterHp()).isEqualTo(bossMonsterFirstHp - physicalAttack.getDamage());
        assertThat(playerInfo.getPlayerCurrentMp()).isNotEqualTo(playerFirstCurrentMp + physicalAttack.getRecoveryMp());
        assertThat(playerInfo.getPlayerCurrentMp()).isEqualTo(playerMaximumMp);
    }

    @DisplayName("[성공 테스트] 플레이어가 마법공격을 수행할 시, 보스 몬스터에게 20 데미지를 주고 자신의 현재 MP를 30 감소시킨다. 그리고 공격 데미지를 반환한다.")
    @Test
    void attack_boss_monster_magic_test() throws Exception {
        // Given
        int bossMonsterFirstHp = 200;
        int playerFirstCurrentMp = 100;
        PlayerAttackOption magicAttack = MAGIC;

        BossMonster bossMonster = createBossMonster(bossMonsterFirstHp);
        Player player = createPlayer(playerFirstCurrentMp);

        // When
        int attackDamage = player.attackBossMonster(
                bossMonster,
                magicAttack
        );

        BossMonsterInfo bossMonsterInfo = bossMonster.getBossMonsterInfo();
        PlayerInfo playerInfo = player.getPlayerInfo();

        // Then
        assertThat(attackDamage).isEqualTo(magicAttack.getDamage());
        assertThat(bossMonsterInfo.getCurrentBossMonsterHp()).isEqualTo(bossMonsterFirstHp - magicAttack.getDamage());
        assertThat(playerInfo.getPlayerCurrentMp()).isEqualTo(playerFirstCurrentMp - magicAttack.getNeedMp());
    }

    @DisplayName("[예외 테스트] 플레이어가 마법공격을 수행할 시, 현재 MP가 부족하면 예외가 발생한다.")
    @Test
    void attack_boss_monster_magic_exception_test() throws Exception {
        // Given
        int playerNotEnoughCurrentMp = 10;
        PlayerAttackOption magicAttack = MAGIC;

        BossMonster bossMonster = createBossMonster();
        Player player = createPlayer(
                createPlayerMp(playerNotEnoughCurrentMp)
        );

        // When
        Throwable throwable = catchThrowable(() -> player.attackBossMonster(
                bossMonster,
                magicAttack
        ));

        // Then
        assertThat(throwable)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("공격을 수행하기 위한 플레이어의 MP가 부족합니다.");
    }
}
