package bossmonster;

public class Hp {

    private int hp;

    public Hp(int hp) {
        this.hp = hp;
    }

    public boolean isOutOfRange(int min, int max) {
        return !(min <= hp && hp <= max);
    }

    public int getHp() {
        return hp;
    }
}
