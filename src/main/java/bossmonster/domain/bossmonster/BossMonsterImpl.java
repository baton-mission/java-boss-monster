package bossmonster.domain.bossmonster;

import bossmonster.domain.player.Player;
import bossmonster.domain.bossmonster.dto.BossMonsterInfo;

import static bossmonster.domain.bossmonster.constant.BossMonsterOption.*;
import static bossmonster.util.GenerateRandomNumber.*;

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

    @Override
    public int attackPlayer(Player player) {
        int bossMonsterRandomDamage = getRandomNumber(
                BOSS_MONSTER_MINIMUM_RANDOM_DAMAGE_LIMIT,
                BOSS_MONSTER_MAXIMUM_RANDOM_DAMAGE_LIMIT
        );

        player.takeDamage(bossMonsterRandomDamage);
        return bossMonsterRandomDamage;
    }
}
