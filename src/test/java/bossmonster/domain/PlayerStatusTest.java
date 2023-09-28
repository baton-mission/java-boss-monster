package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerStatusTest {

    @Test
    void from는_HP와_MP은_정해준_총합과_일치하면_객체를_정상적으로_생성한다() {
        int playerHp = 100;
        int playerMp = 100;

        assertDoesNotThrow(() -> PlayerStatus.from(playerHp, playerMp));
    }

    @Test
    void from는_HP와_MP의_총합이_정해준_총합과_일치하지_않으면_예외를_발생시킨다() {
        int playerHp = 100;
        int playerMp = 50;

        assertThatThrownBy(() -> PlayerStatus.from(playerHp, playerMp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * public void effectedMpBy(AttackType attackType) {
     * playerMp.effectedBy(attackType);
     * }
     * <p>
     * public void effectedHpByBossDamage(int damageFromBoss) {
     * playerHp.effectedByBossDamage(damageFromBoss);
     * }
     * <p>
     * public boolean isHpUnderMin() {
     * return playerHp.isUnderMinHp();
     * }
     */
    @Test
    void effectedMpBy는_마법공격을_하는_경우_playerMP에게_메시지를_보낸다() {
        PlayerMp spyPlayerMp = Mockito.spy(PlayerMp.from(100));
        PlayerStatus playerStatus = PlayerStatus.fromTest(PlayerHp.from(100), spyPlayerMp);

        AttackType attackType = AttackType.MAGICAL;
        playerStatus.effectedMpByAttackType(attackType);

        Mockito.verify(spyPlayerMp).effectedMpByAttackType(attackType);
    }

    @Test
    void effectedHpByBossDamage는_보스공격을_받는_경우_playerHp에게_메시지를_보낸다() {
        PlayerHp spyPlayerHp = Mockito.spy(PlayerHp.from(100));
        PlayerStatus playerStatus = PlayerStatus.fromTest(spyPlayerHp, PlayerMp.from(100));

        int damageFromBoss = 10;
        playerStatus.effectedHpByBossDamage(damageFromBoss);

        Mockito.verify(spyPlayerHp).effectedByBossDamage(damageFromBoss);
    }


    @Test
    void isHpUnderMin는_플레이어의_체력이_끝난다면_playerHp에게_메세지를_보낸다() {
        PlayerHp spyPlayerHp = Mockito.spy(PlayerHp.from(100));
        PlayerStatus playerStatus = PlayerStatus.fromTest(spyPlayerHp, PlayerMp.from(100));

        playerStatus.isHpUnderMin();

        Mockito.verify(spyPlayerHp).isUnderMinHp();
    }
}
