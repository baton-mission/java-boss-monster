package bossmonster.domain.creatures;

public abstract class Creature {
    protected final int totalHp;
    protected final int totalMp;
    protected int hp;
    protected int mp;

    public Creature(int totalHp, int totalMp) {
        this.totalHp = totalHp;
        this.totalMp = totalMp;
        this.hp = totalHp;
        this.mp = totalMp;
    }


    public int getTotalHp() {
        return totalHp;
    }

    public int getTotalMp() {
        return totalMp;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public void damaged(int amount) {
        hp -= amount;
        if (hp < 0) {
            hp = 0;
        }

    }

    public void decreaseMpAs(int mpCost) {
        validatePossibleAttack(mpCost);
        mp -= mpCost;
        if (mp >= totalHp) mp = totalMp;
    }

    private void validatePossibleAttack(int mpCost) {
        if (mp - mpCost < 0) {
            throw new IllegalArgumentException("mp가 부족해서 해당 공격을 사용할 수 없습니다.");
        }
    }
}