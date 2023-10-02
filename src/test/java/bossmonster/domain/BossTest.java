package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class BossTest {

    @Test
    void attackTo는_플레이어에게_데미지를_주고_데미지를_리턴한다() {
        Player mockPlayer = mock(Player.class);
        int bossHp = 100;
        DamageStrategy fixedDamageStrategy = (min, max) -> 20;
        Boss boss = Boss.from(bossHp, fixedDamageStrategy);

        int bossDamage = boss.attackTo(mockPlayer);

        verify(mockPlayer).attackedBy(20);
        assertThat(bossDamage).isEqualTo(20);
    }

    @Test
    void zeroDamage는_0을_리턴한다() {
        int bossHp = 100;
        DamageStrategy fixedDamageStrategy = (min, max) -> 20;
        Boss boss = Boss.from(bossHp, fixedDamageStrategy);

        int zeroDamage = boss.zeroDamage();

        assertThat(zeroDamage).isEqualTo(0);
    }

}
