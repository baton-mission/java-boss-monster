package bossmonster.controller;

import bossmonster.domain.BossMonster;

public class BossMonsterController {

    public BossMonster hit(BossMonster bossMonster, int damage){
        if(bossMonster.getHp() <= damage){
            return new BossMonster(0, bossMonster.getInitHp());
        }
        return new BossMonster(bossMonster.getHp()-damage, bossMonster.getInitHp());
    }

    public boolean die(BossMonster bossMonster){
        return bossMonster.getHp() == 0;
    }
}
