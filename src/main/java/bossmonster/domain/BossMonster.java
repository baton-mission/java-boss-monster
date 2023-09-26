package bossmonster.domain;

public class BossMonster {

    int hp;
    int maxHp;

    public BossMonster(int initialHp) {
        this.hp = initialHp;
        this.maxHp = initialHp;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void reduceHp(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }
}
