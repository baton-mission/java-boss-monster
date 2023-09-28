package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerHpTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void from메서드는_0이하의_값으로_생성할_수_없다(int playerHp) {
        assertThatThrownBy(() -> PlayerHp.from(playerHp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200})
    void from메서드는_0초과의_값으로_생성할_수_있다(int playerHp) {
        assertDoesNotThrow(() -> PlayerHp.from(playerHp));
    }


    @Test
    void plus는_플레이어의_체력에_플레이어의_마력을_더한_값을_반환한다() {
        PlayerHp playerHp = PlayerHp.from(100);
        PlayerMp playerMp = PlayerMp.from(100);

        int totalHpAndMp = playerHp.plus(playerMp);

        assertThat(totalHpAndMp).isEqualTo(200);
    }


    @Test
    void effectedByBossDamage는_보스공격에_의해서_플레이어의_체력이_감소한다() {
        PlayerHp playerHp = PlayerHp.from(100);
        int damageFromBoss = 10;
        PlayerHp expectedPlayerHp = PlayerHp.fromTest(90, 100);

        playerHp.effectedByBossDamage(damageFromBoss);

        assertThat(playerHp).isEqualTo(expectedPlayerHp);
    }

    @Test
    void effectedByBossDamage는_플레이어의_체력이_공격에_의해_0보다_떨어져도_최소값을_유지한다() {
        PlayerHp playerHp = PlayerHp.from(10);
        int damageFromBoss = 20;
        int expectedPlayerHp = 0;

        playerHp.effectedByBossDamage(damageFromBoss);

        assertThat(playerHp.getPlayerHp()).isEqualTo(expectedPlayerHp);
    }

    @Test
    void isUnderMinHp는_플레이어의_체력이_최소값보다_작거나_같으면_true를_반환한다() {
        PlayerHp playerHp = PlayerHp.from(10);
        playerHp.effectedByBossDamage(20);

        boolean isUnderMinHp = playerHp.isUnderMinHp();

        assertTrue(isUnderMinHp);
    }
}
