package bossmonster.domain;

import java.util.Random;

public class RandomDamageGenerator implements DamageGenerator {

	private static final int BOSS_DAMAGE_MAX_RANGE = 21;
	private final Random random = new Random();

	@Override
	public int generate() {
		return random.nextInt(BOSS_DAMAGE_MAX_RANGE);
	}
}
