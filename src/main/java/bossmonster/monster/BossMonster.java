package bossmonster.monster;

import static bossmonster.utils.ErrorMessage.*;

import bossmonster.Hp;

public class BossMonster {

    private static final int MIN_HP = 100;
    private static final int MAX_HP = 300;

    private Hp hp;

    public BossMonster(Hp hp) {
        validate(hp);
        this.hp = hp;
    }

    private void validate(Hp hp) {
        if (hp.isOutOfRange(MIN_HP, MAX_HP)) {
            throw new IllegalArgumentException(BOSS_MONSTER_HP_OUT_OF_RANGE.formatted(MIN_HP, MAX_HP));
        }
    }
}
