package bossmonster;

public class Hp {

    private final int initialHp;
    private int hp;

    public Hp(int hp) {
        this.initialHp = hp;
        this.hp = hp;
    }

    public boolean isOutOfRange(int min, int max) {
        return !(min <= hp && hp <= max);
    }

    public void reduceByDamage(int damage) {
        hp -= damage;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getHp() {
        return hp;
    }
}
