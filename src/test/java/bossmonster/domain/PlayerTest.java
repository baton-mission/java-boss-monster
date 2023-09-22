package bossmonster.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Player")
class PlayerTest {

	@ParameterizedTest
	@ValueSource(strings = {"안녕하세요오", "안녕하십니까"})
	void 생성자는_5자_이하가_아닌경우_IllegalArgumentException을_던진다(String name) {
		assertThatThrownBy(() -> new Player(name))
			.isInstanceOf(IllegalArgumentException.class);
	}
}

