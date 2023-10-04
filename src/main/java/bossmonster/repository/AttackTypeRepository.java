package bossmonster.repository;

import bossmonster.domain.attacktype.AttackType;
import bossmonster.domain.attacktype.MagicalAttack;
import bossmonster.domain.attacktype.PhysicalAttack;

public class AttackTypeRepository {

    private final int PHYSICAL_ATTACK = 1;
    private final int MAGIC_ATTACK = 2;

    public AttackType getAttackType(int typeNum) {
        if (typeNum == PHYSICAL_ATTACK) {
            return new PhysicalAttack();
        }

        if (typeNum == MAGIC_ATTACK) {
            return new MagicalAttack();
        }

        return AttackType.throwAttackTypeException();
    }
}
