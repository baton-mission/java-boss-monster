package bossmonster.domain.attacktype;

public class MagicalAttack extends AttackType {

    private final int TYPE_NUM = 2;
    private final int DAMAGE = 20;
    private final int MP_CHANGE = -30;

    public MagicalAttack() {
        this.typeNum = TYPE_NUM;
        this.damage = DAMAGE;
        this.mpChange = MP_CHANGE;
    }
}
