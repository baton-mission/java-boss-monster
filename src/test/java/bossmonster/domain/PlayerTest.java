package bossmonster.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {
	@Test
	void 플레이어_이름이_6자_이상이면_IllegalArgumentException_발생시킨다() {
		// given
		final String name = "nineWords";
		final int nowHp = 100;
		final int nowMp = 100;

		assertThatThrownBy(() -> new Player(name, nowHp, nowMp))
			.isInstanceOf(IllegalArgumentException.class);
	}


	@Test
	void 플레이어_초기_HP_MP의_합은_200이_아니라면_IllegalArgumentException_발생시킨다() {
		// given
		final String name = "hello";
		final int nowHp = 101;
		final int nowMp = 100;

		assertThatThrownBy(() -> new Player(name, nowHp, nowMp))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
