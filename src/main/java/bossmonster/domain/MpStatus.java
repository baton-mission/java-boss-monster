package bossmonster.domain;

public enum MpStatus {

    REDUCE(30),
    RECOVERY(10);


    private final int effectValue;

    MpStatus(int effectValue) {
        this.effectValue = effectValue;
    }

    public int effect(int playerMp) {
        if (this == REDUCE) {
            return playerMp - effectValue;
        }
        return playerMp + effectValue;
    }
}
