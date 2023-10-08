package bossmonster.dto;

import bossmonster.domain.BossMonster;

public class BossMonsterDto {
    private final int maxHp;
    private final int hp;


    public BossMonsterDto(int maxHp, int hp) {
        this.maxHp = maxHp;
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public static BossMonsterDto from(BossMonster bossMonster) {
        return new BossMonsterDto(bossMonster.getMaxHp(), bossMonster.getCurrentHp());
    }
}
