package bossmonster.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BossMonster")
public class BossMonsterTest {

	@ParameterizedTest
	@ValueSource(ints = {99, 301})
	void 생성자는_100이상_300이하가_아니면_IllegalArgumentException가_발생한다(int hp) {
		assertThatThrownBy(() -> new BossMonster(new Health(hp)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void bossHpZero_메서드는_체력이_0이_아니면_false를_반환한다() {
		Health health = new Health(200);
		BossMonster bossMonster = new BossMonster(health);

		bossMonster.attackedByPlayer(AttackType.PHYSICAL);

		assertFalse(bossMonster.bossHpZero());
	}

	@Test
	void attackedByPlayer_메서드는_공격을_받으면_HP를_감소한다() {
		Health health = new Health(200);
		BossMonster bossMonster = new BossMonster(health);

		bossMonster.attackedByPlayer(AttackType.MAGIC);

		assertThat(bossMonster.getHealth().getHp()).isEqualTo(180);
	}
}
