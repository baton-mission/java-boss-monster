package bossmonster.domain;

import bossmonster.exception.Validator;

public class BossMonster {

    private BossMonsterStatus status;

    public BossMonster(int maxHP) {
        this.status = new BossMonsterStatus(Validator.validateBossMonster(maxHP));
    }

    public boolean isAlive() {
        return status.isAlive();
    }

    public int getMaxHP() {
        return status.getMaxHP();
    }

    public int getCurrentHP() {
        return status.getCurrentHP();
    }

    public int attack() {
        return (int) (Math.random() * 20);
    }

    public void takeDamage(int damage) {
        status.setCurrentHP(status.getCurrentHP() - damage);
    }
}
