package bossmonster.domain;

import bossmonster.exception.GameEndException;
import bossmonster.exception.GamePolicyException;

public class PlayerImpl extends Player {
    public PlayerImpl(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    @Override
    public void attack(Boss boss, int value) {
        recoveryMp(10);
        try {
            boss.hit(value);
        } catch (InterruptedException e) {
            throw new GameEndException(e, true);
        }
    }

    @Override
    public void magicAttack(Boss boss, int value) throws GamePolicyException {
        useMp(30);
        try {
            boss.hit(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
