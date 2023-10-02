package bossmonster.domain.monster;

import java.util.Random;

public class BossMonsterDamageGenerator {

    private static final int MAX_DAMAGE = 20;

    public int generateDamage() {
        return new Random().nextInt(MAX_DAMAGE);
    }
}
