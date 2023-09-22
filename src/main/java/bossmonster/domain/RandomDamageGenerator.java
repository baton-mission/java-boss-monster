package bossmonster.domain;

import java.util.Random;

public class RandomDamageGenerator implements DamageGenerator {

	@Override
	public int generate() {
		Random random = new Random();
		return random.nextInt(21);
	}
}
