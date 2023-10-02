package bossmonster.domain;

public class Player {

    private final String name;
    private int hp;
    private int mp;
    private final int initialHp;
    private final int initialMp;

    public Player(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.initialHp = hp;
        this.initialMp = mp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getInitialMp() {
        return initialMp;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean isDie() {
        return this.hp <= 0;
    }

    public void updateMana(AttackType type) {
        this.mp += type.getManaCost();
        if (this.mp > initialMp) {
            this.mp = initialMp;
        }
    }

    public void getDamage(int bossDamage) {
        this.hp -= bossDamage;
    }
}
