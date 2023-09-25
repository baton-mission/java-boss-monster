package bossmonster.domain;

public class BossMonster {

    int hp;

    public BossMonster(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void reduceHp(int damage) {
        hp -= damage;
    }
}
