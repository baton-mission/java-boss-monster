package bossmonster.domain.attacktype;

public class AttackType {

    protected int typeNum;
    protected int damage;
    protected int mpChange;

    public static AttackType throwAttackTypeException() {
        throw new IllegalArgumentException("올바른 공격 종류를 입력해주세요.");
    }

    public int getTypeNum() {
        return typeNum;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpChange() {
        return mpChange;
    }
}
