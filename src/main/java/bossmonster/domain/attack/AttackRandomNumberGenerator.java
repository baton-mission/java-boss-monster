package bossmonster.domain.attack;

import java.time.LocalDateTime;
import java.util.Random;

public class AttackRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int generate(int start, int end) {
        Random random = new Random();
        random.setSeed(LocalDateTime.now().getSecond());
        return start + random.nextInt(end + 1);
    }
}
