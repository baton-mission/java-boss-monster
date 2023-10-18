package bossmonster.domain.monster;

import bossmonster.domain.player.Player;

public class Monster {

    private MonsterHp monsterHp;

    public Monster(int hp) {
        monsterHp = new MonsterHp(hp);
    }

    public void receiveDamage(int damage) {
        //int damage = RandomNumberGenerator.getRandomNumber();
        monsterHp.reduceHp(damage);
    }

    public void attack(Player player,int damage) {
        player.receiveDamage(damage);
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
