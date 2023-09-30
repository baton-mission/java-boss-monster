package bossmonster.domain.bossmonster;

import bossmonster.domain.bossmonster.dto.BossMonsterInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("보스 몬스터 기능 테스트")
class BossMonsterTest {
    
    @DisplayName("[성공 테스트] 보스 몬스터의 생존 확인 시 현재 HP가 1 이상이면, true를 반환한다.")
    @Test
    void 보스_몬스터_생존_판단_테스트() throws Exception {
        // Given
        BossMonsterHp bossMonsterHp = new BossMonsterHp(200);
        BossMonster bossMonster = setBossMonster(bossMonsterHp);

        // When
        boolean alive = bossMonster.isAlive();

        // Then
        assertThat(alive).isTrue();
    }

    @DisplayName("[성공 테스트] 보스 몬스터의 생존 확인 시 현재 HP가 0 이하이면, false를 반환한다.")
    @Test
    void 보스_몬스터_미생존_판단_테스트() throws Exception {
        // Given
        int bossMonsterFirstHp = 100;
        BossMonsterHp bossMonsterHp = new BossMonsterHp(bossMonsterFirstHp);
        BossMonster bossMonster = setBossMonster(bossMonsterHp);
        int bigDamage = 200;

        // When
        bossMonster.takeDamage(bigDamage);
        boolean alive = bossMonster.isAlive();

        // Then
        assertThat(alive).isFalse();
    }

    @DisplayName("[성공 테스트] 보스 몬스터 정보 조회시, 보스 몬스터의 정보를 반환한다.")
    @Test
    void 보스_몬스터_정보_반환() throws Exception {
        // Given
        int setHp = 200;
        BossMonsterHp bossMonsterHp = new BossMonsterHp(setHp);
        BossMonster bossMonster = setBossMonster(bossMonsterHp);

        // When
        BossMonsterInfo bossMonsterInfo = bossMonster.getBossMonsterInfo();

        // Then
        assertThat(bossMonsterInfo.getMaximumBossMonsterHp()).isEqualTo(setHp);
        assertThat(bossMonsterInfo.getCurrentBossMonsterHp()).isEqualTo(setHp);
    }

    private BossMonster setBossMonster(BossMonsterHp bossMonsterHp) {
        return new BossMonsterImpl(bossMonsterHp);
    }
}
