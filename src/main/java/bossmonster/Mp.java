package bossmonster;

import bossmonster.utils.ErrorMessage;

public class Mp {

    private int mp;
    private final int initialMp;

    public Mp(int mp) {
        this.mp = mp;
        this.initialMp = mp;
    }

    public int getMp() {
        return mp;
    }

    public void consume(int mpConsumption) {
        if (notEnoughMp(mpConsumption)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_ENOUGH_MP);
        }
        int consumed = mp - mpConsumption;
        if (exceedConsumedMp(consumed)) {
            mp -= (consumed - initialMp);
        }
        mp -= mpConsumption;
    }

    private boolean notEnoughMp(int mpConsumption) {
        return mp - mpConsumption < 0;
    }

    private boolean exceedConsumedMp(int consumed) {
        return consumed > initialMp;
    }

    public int getInitialMp() {
        return initialMp;
    }
}
