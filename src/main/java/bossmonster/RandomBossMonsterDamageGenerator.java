package bossmonster;

import java.util.Random;

public class RandomBossMonsterDamageGenerator {

    private static final int MAX_DAMAGE = 20;

    public int generateDamage() {
        return new Random().nextInt(MAX_DAMAGE);
    }
}
