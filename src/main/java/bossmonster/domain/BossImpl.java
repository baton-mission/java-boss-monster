package bossmonster.domain;

import bossmonster.exception.GameEndException;


public class BossImpl extends Boss {

    public BossImpl(int hp) {
        super(hp);
    }

    @Override
    public void attack(Player player, int value) {
        try {
            player.hit(value);
        } catch (InterruptedException e) {
            throw new GameEndException(e, false);
        }
    }
}
