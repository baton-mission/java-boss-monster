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
        int newHp = hp - monsterAttack.hp;
        if (isUnderMinScore(newHp)) {
            hp = 0;
        }
        if (!isUnderMinScore(newHp)) {
            hp = newHp;
        }
    }

    private boolean isUnderMinScore(int newHp) {
        return newHp <= 0;
    }

    public void decreaseBy(PlayerAttack playerAttack) {
        int newHp = playerAttack.applyHp(hp);
        if (isUnderMinScore(newHp)) {
            hp = 0;
        }
        if (!isUnderMinScore(newHp)) {
            hp = newHp;
        }
    }

    public boolean isEmpty() {
        return hp <= 0;
    }
}
