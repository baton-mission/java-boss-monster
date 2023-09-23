package bossmonster.domain;

import java.util.Random;

public class RandomDamageGenerator implements DamageGenerator {

	private static final int BOSS_DAMAGE_MAX_RANGE = 21;

	@Override
	public int generate() {
		Random random = new Random();
		return random.nextInt(BOSS_DAMAGE_MAX_RANGE);
	}
}
