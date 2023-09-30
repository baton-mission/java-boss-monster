package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CurrentPlayerHpTest {


    /**
     * public CurrentPlayerHp effectedByBossDamage(int damageFromBoss) {
     * int effectedPlayerHp = effectedPlayerHpFromBossDamage(damageFromBoss);
     * int currentPlayerHp = calculatePlayerHpNotToUnderMin(effectedPlayerHp);
     * return new CurrentPlayerHp(currentPlayerHp);
     * }
     * <p>
     * <p>
     * private int calculatePlayerHpNotToUnderMin(int effectedPlayerHp) {
     * return Math.max(MIN_HP, effectedPlayerHp);
     * }
     * <p>
     * private int effectedPlayerHpFromBossDamage(int damageFromBoss) {
     * return currentPlayerHp - damageFromBoss;
     * }
     */
    @Test
    void effectedByBossDamage는_현재_플레이어_체력에서_보스의_공격력만큼_빼준다() {
        CurrentPlayerHp currentPlayerHp = CurrentPlayerHp.from(10);
        int damageFromBoss = 3;
        CurrentPlayerHp expected = CurrentPlayerHp.from(7);

        CurrentPlayerHp actual = currentPlayerHp.effectedByBossDamage(damageFromBoss);

        assertEquals(expected, actual);
    }

    @Test
    void effectedByBossDamage는_공격에의해_죽어도_HP는_음수값을_가지지_않는다() {
        CurrentPlayerHp currentPlayerHp = CurrentPlayerHp.from(2);
        int damageFromBoss = 3;
        CurrentPlayerHp expectedPlayerHp = CurrentPlayerHp.from(0);

        CurrentPlayerHp actualPlayerHp = currentPlayerHp.effectedByBossDamage(damageFromBoss);

        assertEquals(expectedPlayerHp, actualPlayerHp);
    }

    @Test
    void isUnderMinHp는_체력이_0보다_작거나_같으면_true를_반환한다() {
        CurrentPlayerHp currentPlayerHp = CurrentPlayerHp.from(0);

        boolean isUnderMinHp = currentPlayerHp.isUnderMinHp();

        assertThat(isUnderMinHp).isTrue();
    }
}
