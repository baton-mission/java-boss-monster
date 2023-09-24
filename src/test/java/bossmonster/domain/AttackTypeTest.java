package bossmonster.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AttackType")
class AttackTypeTest {

	@Test
	void valueOfType_메서드는_타입이_1이_주어지면_enum의_물리공격을_반환한다() {
		assertThat(AttackType.valueOfType("1")).isEqualTo(AttackType.PHYSICAL);
	}

	@Test
	void valueOfType_메서드는_타입이_2이_주어지면_enum의_마법공격을_반환한다() {
		assertThat(AttackType.valueOfType("2")).isEqualTo(AttackType.MAGIC);
	}

	@Test
	void valueOfType_메서드는_타입이_1또는_2가_주어지지_않으면_예외가_발생한다() {
		assertThatThrownBy(() -> AttackType.valueOfType("3")).isInstanceOf(IllegalArgumentException.class);
	}
}
