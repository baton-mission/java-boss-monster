package bossmonster.domain;

public class BossMonster {

    int hp;
    int turnCount;

    public BossMonster(int hp) {
        this.hp = hp;
        turnCount = 1;
    }

    public int getHp() {
        return hp;
    }

    public int getTurnCount() {
        return turnCount;
    }
}
