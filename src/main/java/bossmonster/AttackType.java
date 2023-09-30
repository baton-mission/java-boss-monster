package bossmonster;

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

    public AttackType(int typeNum) {
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

    public int getDamage() {
        return damage;
    }

    public int getMpChange() {
        return mpChange;
    }
}
