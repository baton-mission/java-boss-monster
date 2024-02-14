package bossmonster.Domain;

public class Boss {
    private final int hp;

    public Boss(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public Boss setHp(int hp) {
        return new Boss(hp);
    }
}
