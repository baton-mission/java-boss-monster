package bossmonster.domain;

public class Hp {
    public static final int EMPTY_HP = 0;
    private int hp;

    public Hp(int hp) {
        this.hp = hp;
    }

    public void decreaseBy(Hp monsterAttack) {
        int newHp = hp - monsterAttack.hp;
        if (isUnderMinScore(newHp)) {
            hp = EMPTY_HP;
        }
        if (!isUnderMinScore(newHp)) {
            hp = newHp;
        }
    }

    private boolean isUnderMinScore(int newHp) {
        return newHp <= EMPTY_HP;
    }

    public void decreaseBy(PlayerAttack playerAttack) {
        int newHp = playerAttack.applyHp(hp);
        if (isUnderMinScore(newHp)) {
            hp = EMPTY_HP;
        }
        if (!isUnderMinScore(newHp)) {
            hp = newHp;
        }
    }

    public boolean isEmpty() {
        return hp <= EMPTY_HP;
    }

    public int getHp() {
        return hp;
    }
}
