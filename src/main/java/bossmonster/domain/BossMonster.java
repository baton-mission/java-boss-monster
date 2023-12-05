package bossmonster.domain;

import bossmonster.exception.Validator;

public class BossMonster {

    private int totalHP;
    private int currentHP;

    public BossMonster(int hp) {
        totalHP = Validator.validateBossMonster(hp);
    }

    public int getTotalHP() {
        return totalHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }
}
