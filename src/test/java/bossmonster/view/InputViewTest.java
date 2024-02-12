package bossmonster.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

class InputViewTest {
	private final InputView inputView = new InputView();

	private static InputStream generateUserInput(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}

	@Test
	void 몬스터의_초기_HP가_정상_범위라면_입력된_HP를_반환한다() {
		// given
		final String monsterHp = "200";

		// when
		InputStream in = generateUserInput(monsterHp);
		System.setIn(in);
		final int monsterHpInt = inputView.readMonsterHp();

		// then
		assertThat(monsterHpInt).isEqualTo(Integer.parseInt(monsterHp));
	}

	@Test
	void 플레이어_이름이_5자_이하이면_입력된_이름을_반환한다() {
		// given
		final String name = "hello";

		// when
		InputStream in = generateUserInput(name);
		System.setIn(in);
		final String playerName = inputView.readPlayerName();

		// then
		assertThat(playerName).isEqualTo(name);
	}

	@Test
	void 플레이어_초기_HP_MP의_합이_200이라면_입력된_HP와_MP를_반환한다() {
		// given
		final String HpMp = "100,100";
		final List<Integer> expected = List.of(100, 100);

		// when
		InputStream in = generateUserInput(HpMp);
		System.setIn(in);
		final List<Integer> playerHpMp = inputView.readPlayerHpMp();

		// then
		assertThat(playerHpMp).isEqualTo(expected);
	}

	@Test
	void 공격_선택_시_1과_2로_선택하면_입력된_공격을_반환한다() {
		// given
		final String attack = "1";

		// when
		InputStream in = generateUserInput(attack);
		System.setIn(in);
		final int attackInt = inputView.readWhetherAttack();

		// given
		assertThat(attackInt).isEqualTo(Integer.parseInt(attack));
	}

	@Test
	void 몬스터의_초기_HP는_100미만이면_IllegalArgumentException_발생시킨다() {
		// given
		final String monsterHp = "50";

		// when
		InputStream in = generateUserInput(monsterHp);
		System.setIn(in);

		// then
		assertThatThrownBy(() -> inputView.readMonsterHp())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 몬스터의_초기_HP는_300초과면_IllegalArgumentException_발생시킨다() {
		// given
		final String monsterHp = "10000";

		// when
		InputStream in = generateUserInput(monsterHp);
		System.setIn(in);

		// then
		assertThatThrownBy(() -> inputView.readMonsterHp())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 플레이어_이름이_6자_이상이면_IllegalArgumentException_발생시킨다() {
		// given
		final String name = "nineWords";

		// when
		InputStream in = generateUserInput(name);
		System.setIn(in);

		// then
		assertThatThrownBy(() -> inputView.readPlayerName())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 플레이어_초기_HP_MP의_합이_200이_아니라면_IllegalArgumentException_발생시킨다() {
		// given
		final String HpMp = "100,101";

		// when
		InputStream in = generateUserInput(HpMp);
		System.setIn(in);

		// given
		assertThatThrownBy(() -> inputView.readPlayerHpMp())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 공격_선택_시_1과_2로_선택하지_않으면_IllegalArgumentException_발생시킨다() {
		// given
		final String attack = "30";

		// when
		InputStream in = generateUserInput(attack);
		System.setIn(in);

		// given
		assertThatThrownBy(() -> inputView.readWhetherAttack())
			.isInstanceOf(IllegalArgumentException.class);
	}
}