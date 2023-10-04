package bossmonster.domain.attacktype;

public class PhysicalAttack extends AttackType {

    private final int TYPE_NUM = 1;
    private final int DAMAGE = 10;
    private final int MP_CHANGE = 10;

    public PhysicalAttack() {
        this.typeNum = TYPE_NUM;
        this.damage = DAMAGE;
        this.mpChange = MP_CHANGE;
    }
}
