package bossmonster.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BossMonsterTest {

    @ParameterizedTest(name = "hp: " + "{argumentsWithNames}")
    @CsvSource({"100", "300"})
    void 보스_몬스터_생성_정상(int hp) {
        BossMonster createdBossMonster = new BossMonster(hp);

        int actual = createdBossMonster.getHp();
        assertThat(actual).isEqualTo(hp);
    }

    @Nested
    class 보스_몬스터_생성_실패 {
        @ParameterizedTest(name = "hp: " + "{argumentsWithNames}")
        @CsvSource({"-1", "0", "99", "301"})
        void 옳바르지_않은_HP_범위면_에러가_발생한다(int hp) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BossMonster(hp))
                    .withMessage(BossMonster.INVALID_HP_MESSAGE);
        }
    }
}
