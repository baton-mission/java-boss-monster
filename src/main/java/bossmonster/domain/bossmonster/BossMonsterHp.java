package bossmonster.domain.bossmonster;

import static bossmonster.domain.bossmonster.constant.BossMonsterOption.*;

public class BossMonsterHp {
    private final int maximumHp;
    private int currentHp;

    public BossMonsterHp(int hp) {
        validateHp(hp);
        this.maximumHp = hp;
        this.currentHp = hp;
    }

    public int getMaximumHp() {
        return maximumHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void decreaseCurrentHp(int decreaseHp) {
        this.currentHp -= decreaseHp;
    }

    private void validateHp(int hp) {
        if (BOSS_MONSTER_MINIMUM_HP_LIMIT > hp || BOSS_MONSTER_MAXIMUM_HP_LIMIT < hp) {
            throw new IllegalArgumentException("Invalid Boss Monster HP");
        }
    }
}
