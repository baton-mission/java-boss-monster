package bossmonster.domain;

import bossmonster.exception.GamePolicyException;

public class PlayerImpl extends Player {
    public PlayerImpl(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Boss boss, int value) {
        recoveryMp(10);
        boss.hit(value);
    }

    @Override
    public void magicAttack(Boss boss, int value) throws GamePolicyException {
        useMp(30);
        boss.hit(value);
    }
}
