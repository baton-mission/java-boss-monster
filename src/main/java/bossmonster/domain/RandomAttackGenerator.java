package bossmonster.domain;

import java.util.Random;

public class RandomAttackGenerator implements AttackGenerator{
    public static final int MAX_MONSTER_ATTACK = 20;
    private final Random random;

    public RandomAttackGenerator() {
        this.random = new Random();
    }

    @Override
    public Hp generate() {
        return new Hp(random.nextInt(MAX_MONSTER_ATTACK));
    }
}
