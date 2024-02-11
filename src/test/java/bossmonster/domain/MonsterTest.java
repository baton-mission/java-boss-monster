package bossmonster.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonsterTest {
	@Test
	void 몬스터의_초기_HP는_100이상이다() {
		// given
		final int hp_less_than_100 = 50;

		assertThatThrownBy(() -> new Monster(hp_less_than_100))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 몬스터의_초기_HP는_300이하이다() {
		// given
		final int hp_more_than_300 = 10000;

		// when
		assertThatThrownBy(() -> new Monster(hp_more_than_300))
			.isInstanceOf(IllegalArgumentException.class);
	}
}