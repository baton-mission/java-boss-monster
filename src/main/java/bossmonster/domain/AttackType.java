package bossmonster.domain;

public class AttackType {

    private final int PHYSICAL_ATTACK = 1;
    private final int PHYSICAL_DAMAGE = 10;
    private final int PHYSICAL_MP_CHANGE = 10;
    private final int MAGIC_ATTACK = 2;
    private final int MAGIC_DAMAGE = 20;
    private final int MAGIC_MP_CHANGE = -30;

    private int typeNum;
    private int damage;
    private int mpChange;

    public int getTypeNum() {
        return typeNum;
    }

    public int getDamage() {
        return damage;
    }

    public int getMpChange() {
        return mpChange;
    }

    public void setType(int typeNum) {
        validateAttackType(typeNum);
        this.typeNum = typeNum;

        if (typeNum == PHYSICAL_ATTACK) {
            damage = PHYSICAL_DAMAGE;
            mpChange = PHYSICAL_MP_CHANGE;
        }

        if (typeNum == MAGIC_ATTACK) {
            damage = MAGIC_DAMAGE;
            mpChange = MAGIC_MP_CHANGE;
        }
    }

    private void validateAttackType(int typeNum) {
        if (!(typeNum == PHYSICAL_ATTACK) && !(typeNum == MAGIC_ATTACK)) {
            throw new IllegalArgumentException();
        }
    }
}
