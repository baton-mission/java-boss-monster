package bossmonster.domain;

public class BossMonster {

    int hp;
    int maxHp;

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        validateBossStatus(hp);
        this.hp = hp;
        this.maxHp = hp;
    }

    public void reduceHp(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    private void validateBossStatus(int hp) {
        if (hp < 100 || hp > 300) {
            throw new IllegalArgumentException();
        }
    }
}
