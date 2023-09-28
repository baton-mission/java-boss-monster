package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerMpTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void from는_정상범위에_있는_값으로는_객체를_생성할_수_있다(int playerMp) {
        assertDoesNotThrow(() -> PlayerMp.from(playerMp));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    void from는_0보다_작은_값으로는_객체를_생성할_수_없다(int playerMp) {
        assertThatThrownBy(() -> PlayerMp.from(playerMp))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void plus는_플레이어의_마력에_플레이어의_체력을_더한_값을_반환한다() {
        int playerHp = 100;
        PlayerMp playerMp = PlayerMp.from(100);

        int totalHpAndMp = playerMp.plus(playerHp);

        assertThat(totalHpAndMp).isEqualTo(200);
    }
    
    @Test
    void effectedBy는_마법공격을_하는_경우_MP가_감소한다() {
        PlayerMp playerMp = PlayerMp.from(100);
        AttackType attackType = AttackType.MAGICAL;
        PlayerMp expectedPlayerMp = PlayerMp.fromTest(70, 100);

        playerMp.effectedBy(attackType);

        assertThat(playerMp).isEqualTo(expectedPlayerMp);
    }

    @Test
    void effectedBy는_마법공격을_위한_충분한_MP가_없을때_예외를_발생시킨다() {
        PlayerMp playerMp = PlayerMp.from(10);
        AttackType attackType = AttackType.MAGICAL;

        assertThatThrownBy(() -> playerMp.effectedBy(attackType))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void effectedBy는_물리공격을_하는_경우_MP가_회복된다() {
        PlayerMp playerMp = PlayerMp.fromTest(80, 100);
        AttackType attackType = AttackType.PHYSICAL;
        PlayerMp expectedPlayerMp = PlayerMp.fromTest(90, 100);

        playerMp.effectedBy(attackType);

        assertThat(playerMp).isEqualTo(expectedPlayerMp);
    }

    @Test
    void effectedBy는_물리공격을_통해_MP을_회복해도_최대치_그_이상으로는_회복하지_않는다() {
        PlayerMp playerMp = PlayerMp.from(100);
        AttackType attackType = AttackType.PHYSICAL;
        PlayerMp expectedPlayerMp = PlayerMp.from(100);

        playerMp.effectedBy(attackType);

        assertThat(playerMp).isEqualTo(expectedPlayerMp);
    }

}
