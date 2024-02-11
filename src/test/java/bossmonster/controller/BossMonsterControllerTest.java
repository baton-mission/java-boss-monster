package bossmonster.controller;

import bossmonster.domain.BossMonster;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BossMonsterControllerTest {

    private final static int HpInit = 100;
    private final static int DAMAGE = 17;
    private final static int deadDamage = 100;
    private final BossMonster bossMonster = new BossMonster(HpInit);
    private final BossMonster bossMonsterDead = new BossMonster(0);
    private final BossMonster bossMonsterHit = new BossMonster(HpInit - DAMAGE);
    private final BossMonsterController bossMonsterController = new BossMonsterController();

    @Test
    @DisplayName("보스 몬스터 공격당했을 때 Hp 테스트")
    void hitTest(){
        BossMonster newBossMonster = bossMonsterController.hit(bossMonster, DAMAGE);
        assertThat(newBossMonster.getHp()).isEqualTo(bossMonsterHit.getHp());
    }

    @Test
    @DisplayName("보스 몬스터 공격당해서 죽었을 때 Hp 테스트")
    void deadTest(){
        BossMonster newBossMonster = bossMonsterController.hit(bossMonster, deadDamage);
        assertThat(newBossMonster.getHp()).isEqualTo(bossMonsterDead.getHp());
    }

    @Test
    @DisplayName("보스 몬스터 죽었는지 확인 테스트")
    void isDeadTest(){
        assertThat(bossMonsterController.die(bossMonsterDead)).isTrue();
        assertThat(bossMonsterController.die(bossMonster)).isFalse();
    }
}
