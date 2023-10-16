package bossmonster.domain.monster;

import bossmonster.domain.player.Player;

public class Monster {

    private MonsterHp monsterHp;

    public Monster(int hp) {
        monsterHp = new MonsterHp(hp);
    }

    public void sufferDamage(int damage) {
        monsterHp.reduceHp(damage);
    }

    public void takeDamage(int damage, Player player) {
        player.sufferDamage(damage);
    }

    public boolean isAlive() {
        return monsterHp.hasHPGreaterThanZero();
    }

    public boolean isDead() {
        return !isAlive();
    }

    public int getCurrentHp() {
        return monsterHp.getCurrentHp();
    }

    public int getMaxHp() {
        return monsterHp.getMaxHp();
    }
}
