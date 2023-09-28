package bossmonster.monster;

import static bossmonster.utils.ErrorMessage.*;

public class BossMonster {

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 300;

    private int hp;

    public BossMonster(int hp) {
        validate(hp);
        this.hp = hp;
    }

    private void validate(int hp) {
        if (isOutOfRange(hp)) {
            throw new IllegalArgumentException(HP_OUT_OF_RANGE.formatted(MIN_HP, MAX_HP));
        }
    }

    private boolean isOutOfRange(int hp) {
        return !(MIN_HP <= hp && hp <= MAX_HP);
    }
}
