package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Player")
class PlayerTest {

	@ParameterizedTest
	@ValueSource(strings = {"안녕하세요오", "안녕하세요오오"})
	void 생성자는_5자_이하가_아닌경우_IllegalArgumentException을_던진다(String name) {
		assertThatThrownBy(() -> new Player(name, new Health(100, 100)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"100:90", "198:1", "100:50"}, delimiter = ':')
	void 생성자는_HP와_MP의_합이_200이_되지_않는다면_IllegalArgumentException을_던진다(int hp, int mp) {
		assertThatThrownBy(() -> new Player("dori", new Health(hp, mp)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void playerHpZero_메서드는_HP가_0보다_작으면_true를_반환한다() {
		Health health = new Health(100, 100);
		Player player = new Player("dori", health);

		player.attackedByBossMonster(150);

		assertTrue(player.isPlayerDead());
	}

	@Test
	void attackedByBossMonster_메서드는_보스몬스터한테_데미지를_입으면_HP가_감소한다() {
		Health health = new Health(100, 100);
		Player player = new Player("dori", health);

		player.attackedByBossMonster(15);

		assertThat(player.getHealth().getHp()).isEqualTo(85);
	}

	@Test
	void validateRemainMP_메서드는_MP가_충분하면_예외를_발생시키지_않는다() {
		Health health = new Health(190, 10);
		Player player = new Player("dori", health);

		assertDoesNotThrow(() -> player.validateRemainMP(AttackType.PHYSICAL));
	}

	@Test
	void validateRemainMP_메서드는_MP가_충분하지_않으면_예외를_발생시킨다() {
		Health health = new Health(190, 10);
		Player player = new Player("dori", health);

		assertThatThrownBy(() -> player.validateRemainMP(AttackType.MAGIC)).isInstanceOf(
			IllegalArgumentException.class);
	}
}

