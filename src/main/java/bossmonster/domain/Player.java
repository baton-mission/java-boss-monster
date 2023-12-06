package bossmonster.domain;

import bossmonster.exception.Validator;

public class Player {

    private String name;
    private PlayerStatus status;

    public Player(String name, int maxHP, int maxMP) {
        this.name = Validator.validatePlayerName(name);
        Validator.validatePlayerStatus(maxHP, maxMP);
        this.status = new PlayerStatus(maxHP, maxMP);
    }

    public String getName() {
        return name;
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

    public int getMaxMP() {
        return status.getMaxMP();
    }

    public int getCurrentMP() {
        return status.getCurrentMP();
    }

    public int attack(AttackType attackType) {
        if (attackType.getName().equals(AttackType.ATTACK_TYPE_NORMAL.getName())) {
            recoverMP(attackType.getMpRecover());
        }
        if (attackType.getName().equals(AttackType.ATTACK_TYPE_MAGIC.getName())) {
            consumeMP(attackType.getMpUsage());
        }
        return attackType.getDamage();
    }

    public void takeDamage(int damage) {
        status.setCurrentHP(status.getCurrentHP() - damage);
    }

    private void recoverMP(int mp) {
        status.setCurrentMP(status.getCurrentMP() + mp);
    }

    private void consumeMP(int mp) {
        status.setCurrentMP(status.getCurrentMP() - mp);
    }
}
