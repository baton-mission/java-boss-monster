package bossmonster.domain;

import java.util.Random;

public class RandomAttackGenerator implements AttackGenerator{
    private final Random random;

    public RandomAttackGenerator() {
        this.random = new Random();
    }

    @Override
    public Hp generate() {
        return new Hp(random.nextInt(20));
    }
}
