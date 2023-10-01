package bossmonster.util;

import bossmonster.domain.bossmonster.BossMonster;
import bossmonster.domain.bossmonster.BossMonsterHp;
import bossmonster.domain.bossmonster.BossMonsterImpl;

public class BossMonsterFixture {
    private static final int DEFAULT_BOSS_MONSTER_HP = 200;

    public static BossMonster createBossMonster() {
        return new BossMonsterImpl(
                createBossMonsterHp()
        );
    }

    public static BossMonster createBossMonster(int hp) {
        BossMonsterHp bossMonsterHp = createBossMonsterHp(hp);
        return new BossMonsterImpl(bossMonsterHp);
    }

    public static BossMonsterHp createBossMonsterHp() {
        return new BossMonsterHp(DEFAULT_BOSS_MONSTER_HP);
    }

    public static BossMonsterHp createBossMonsterHp(int hp) {
        return new BossMonsterHp(hp);
    }
}
