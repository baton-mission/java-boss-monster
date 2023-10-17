package bossmonster.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @CsvSource({
            "a, 1, 199",
            "user1, 200, 0"
    })
    void 플레이어_생성_성공(String name, int hp, int mp) {
        Player player = new Player(name, hp, mp);

        assertThat(player.getName()).isEqualTo(name);
        assertThat(player.getHp().getCurrentEnergy()).isEqualTo(hp);
        assertThat(player.getMp().getCurrentEnergy()).isEqualTo(mp);
    }

    @Nested
    class 플레이어_생성_실패 {

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "user12"})
        void 이름이_비어있거나_5_글자_이상이면_에러가_발생한다(String name) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player(name, 1, 199))
                    .withMessage(Player.INVALID_NAME_MASSAGE);
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 0})
        void HP가_1보다_작으면_에러가_발생한다(int hp) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player("user1", hp, 200 - hp))
                    .withMessage(Player.INVALID_HP_MESSAGE);
        }

        @Test
        void MP가_0보다_작으면_에러가_발생한다() {
            int mp = -1;

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player("user1", 200 - mp, mp))
                    .withMessage(Player.INVALID_MP_MESSAGE);
        }

        @ParameterizedTest
        @CsvSource({
                "1, 0",
                "1, 198",
                "1, 200"
        })
        void HP와_MP_합이_200이_아니면_에러가_발생한다(int hp, int mp) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player("user1", hp, mp))
                    .withMessage(Player.INVALID_STAT_MESSAGE);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "90, 100, PHYSICAL",
            "80, 70, MAGICAL"
    })
    void 플레이어_공격_성공(int remainBossMonsterHp, int remainPlayerMp, AttackType attackType) {
        BossMonster bossMonster = new BossMonster(100);
        Player player = new Player("user1", 100, 100);

        player.attack(bossMonster, attackType);

        assertThat(bossMonster.getHp().getCurrentEnergy()).isEqualTo(remainBossMonsterHp);
        assertThat(player.getMp().getCurrentEnergy()).isEqualTo(remainPlayerMp);
    }

    @Test
    void 플레이어가_물리공격하면_마나가_회복된다() {
        BossMonster bossMonster = new BossMonster(100);
        Player player = new Player("user1", 100, 100);
        player.attack(bossMonster, AttackType.MAGICAL);

        player.attack(bossMonster, AttackType.PHYSICAL);

        assertThat(player.getMp().getCurrentEnergy()).isEqualTo(80);
    }

    @Test
    void 플레이어가_공격하면_보스_몬스터의_피격_횟수가_증가한다() {
        BossMonster bossMonster = new BossMonster(100);
        Player player = new Player("user1", 100, 100);

        player.attack(bossMonster, AttackType.PHYSICAL);

        int attackedCount = bossMonster.getAttackedCount();
        assertThat(attackedCount).isEqualTo(1);
    }
}
