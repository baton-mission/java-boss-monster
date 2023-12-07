package bossmonster.domain;

public class Hp {
    private int hp;

    public Hp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void decreaseBy(Hp monsterAttack) {
        hp = hp - monsterAttack.hp;
    }

    public void decreaseBy(PlayerAttack playerAttack) {
        hp = playerAttack.applyHp(hp);
    }

    public boolean isEmpty() {
        return hp == 0;
    }
}
