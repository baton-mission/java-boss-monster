package bossmonster.domain.monster;

import bossmonster.domain.player.Player;

public class Monster {

    private int currentHp;
    private int maxHp;

    public Monster(int hp) {
        validateHp(hp);
        this.currentHp = hp;
        this.maxHp = hp;
    }

    private void validateHp(int hp) {
        if (100 > hp || hp > 300) {
            throw new IllegalArgumentException("몬스터의 HP는 100이상 300이하여야합니다.");
        }
    }

    public void sufferDamage(int damage) {
        this.currentHp = currentHp - damage;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }

    public void takeDamage(int damage, Player player) {
        player.sufferDamage(damage);
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
