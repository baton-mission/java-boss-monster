package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RandomDamageGenerator")
class RandomDamageGeneratorTest {

	@Test
	void 랜덤으로_받아오는_숫자는_0이상_20이하의_값이어야_함() {
		RandomDamageGenerator damageGenerator = new RandomDamageGenerator();

		int damage = damageGenerator.generate();

		assertTrue(damage >= 0 && damage <= 20);
	}
}
