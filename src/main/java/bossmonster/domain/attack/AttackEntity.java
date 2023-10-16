package bossmonster.domain.attack;

import bossmonster.domain.creatures.Creature;

public final class AttackEntity {
    private final Creature attacker;

    private final Creature attacked;
    private final int damage;
    private final int mpCost;

    public AttackEntity(Creature attacker, Creature attacked, int damage, int mpCost) {
        this.attacker = attacker;
        this.attacked = attacked;
        this.damage = damage;
        this.mpCost = mpCost;
    }

    public AttackEntity(Creature attacker, Creature attacked, AttackType.Player attackType) {
        this.attacker = attacker;
        this.attacked = attacked;
        this.damage = attackType.getDamage();
        this.mpCost = attackType.getMpCost();
    }

    public Creature getAttacker() {
        return attacker;
    }

    public Creature getAttacked() {
        return attacked;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpCost() {
        return mpCost;
    }

    public int attack() {
        if (attacker.getHp() <= 0 || attacked.getHp() <= 0) return 0;

        this.attacker.decreaseMpAs(mpCost);
        this.attacked.damaged(damage);
        return damage;
    }
}
