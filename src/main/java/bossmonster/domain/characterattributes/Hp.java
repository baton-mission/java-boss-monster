package bossmonster.domain.characterattributes;

public class Hp {

    private int hp;
    private final int initialHp;

    public Hp(int hp) {
        this.hp = hp;
        this.initialHp = hp;
    }

    public boolean isOutOfRange(int min, int max) {
        return !(min <= hp && hp <= max);
    }

    public void reduceByDamage(int damage) {
        hp -= damage;
    }

    public boolean isZeroOrLess() {
        return hp <= 0;
    }

    public int getHp() {
        return hp;
    }

    public int getInitialHp() {
        return initialHp;
    }
}
