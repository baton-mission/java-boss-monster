package bossmonster.domain.bossmonster;

import bossmonster.dto.BossMonsterInfo;

public class BossMonsterImpl
        implements BossMonster {

    private final BossMonsterHp bossMonsterHp;

    public BossMonsterImpl(BossMonsterHp bossMonsterHp) {
        this.bossMonsterHp = bossMonsterHp;
    }

    @Override
    public void takeDamage(int damage) {
        bossMonsterHp.decreaseCurrentHp(damage);
    }

    @Override
    public boolean isAlive() {
        if (bossMonsterHp.isCurrentHpZeroOrBelow()) {
            return false;
        }

        return true;
    }

    @Override
    public BossMonsterInfo getBossMonsterInfo() {
        return BossMonsterInfo.of(
                bossMonsterHp.getMaximumHp(),
                bossMonsterHp.getCurrentHp()
        );
    }
}
