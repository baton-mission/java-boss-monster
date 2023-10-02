package bossmonster.dto;

import java.util.List;

import bossmonster.domain.monster.BossMonster;

public class BossMonsterInfo {

    private int hp;
    private int initialHp;
    private String appearance;

    private BossMonsterInfo(List<Integer> hpAndInitialHp, String appearance) {
        this.hp = hpAndInitialHp.get(0);
        this.initialHp = hpAndInitialHp.get(1);
        this.appearance = appearance;
    }

    public static BossMonsterInfo from(BossMonster bossMonster) {
        return new BossMonsterInfo(bossMonster.hpAndInitialHp(), bossMonster.appearance());
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getHp() {
        return hp;
    }

    public String getAppearance() {
        return appearance;
    }
}
