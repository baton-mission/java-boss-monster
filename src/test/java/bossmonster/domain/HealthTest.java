package bossmonster.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Health")
class HealthTest {

	private Health health;

	@BeforeEach
	void setUp() {
		health = new Health(100, 50);
	}

	@Test
	void validateBossHpRange_메서드는_보스의_피가_100이상_300이하가_되지않으면_true를_반환한다() {
		assertFalse(health.validateBossHpRange());

		Health newHealth = new Health(305);
		assertTrue(newHealth.validateBossHpRange());
	}

	@Test
	void validatePlayerHpAndMp_메서드는_HP와_MP합이_200이_되지않으면_true를_반환한다() {
		assertTrue(health.validatePlayerHpAndMp());

		Health newHealth = new Health(100, 100);
		assertFalse(newHealth.validatePlayerHpAndMp());
	}

	@Test
	void isHpZero_메서드는_HP가_0이면_true_를_반환한다() {
		assertFalse(health.isDead());

		Health newHealth = new Health(0, 50);
		assertTrue(newHealth.isDead());
	}

	@Test
	void spendHP_메서드는_30의_데미지를_받으면_HP가_30이_줄어든다() {
		health.spendHp(30);
		assertEquals(70, health.getHp());
	}

	@Test
	void calculateMP_메서드는_물리_공격을_하면_마나가_10_증가한다() {
		health.calculateMp(AttackType.PHYSICAL);

		assertEquals(50, health.getMp());  // 최대 마나가 50이므로 물리 공격을 해도 60이 되지 않는다.
	}

	@Test
	void calculateMP_메서드는_마법_공격을_하면_마나가_30_줄어든다() {
		health.calculateMp(AttackType.MAGIC);

		assertEquals(20, health.getMp());
	}

	@Test
	void checkPlayerMp_메서드는_마나가_30보다_작으면_사용할_수_없다() {
		assertFalse(health.checkPlayerMp(AttackType.MAGIC));
	}
}

