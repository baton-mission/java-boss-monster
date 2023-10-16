package bossmonster.domain;

import bossmonster.domain.attack.AttackRandomNumberGenerator;
import bossmonster.domain.attack.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private final RandomNumberGenerator randomNumberGenerator = new AttackRandomNumberGenerator();

    @Test
    @DisplayName("0 ~ 20 사이로 나오도록 설정한 올바르게 나오면 성공한다")
    @RepeatedTest(20)
    void 랜덤_데미지_성공_테스트() {
        //given
        int number = randomNumberGenerator.generate(0, 20);
        //when, then
        Assertions.assertThat(number).isBetween(0, 20);
    }

}