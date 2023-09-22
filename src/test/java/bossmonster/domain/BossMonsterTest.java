package bossmonster.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BossMonster")
public class BossMonsterTest {

	@ParameterizedTest
	@ValueSource(ints = {99, 301})
	void 생성자는_100이상_300이하가_아니면_IllegalArgumentException가_발생한다(int hp) {
		Assertions.assertThatThrownBy(() -> new BossMonster(hp))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
