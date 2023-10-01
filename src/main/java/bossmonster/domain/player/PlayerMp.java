package bossmonster.domain.player;

import static bossmonster.domain.player.constant.PlayerOption.PLAYER_MAXIMUM_MP_LIMIT;
import static bossmonster.domain.player.constant.PlayerOption.PLAYER_MINIMUM_MP_LIMIT;

public class PlayerMp {
    private final int maximumMp;
    private int currentMp;

    public PlayerMp(int mp) {
        validateMp(mp);
        this.maximumMp = mp;
        this.currentMp = mp;
    }

    public int getMaximumMp() {
        return maximumMp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public boolean hasEnoughMpForAttack(int enoughMp) {
        return enoughMp <= currentMp;
    }

    public void increaseCurrentMp(int increaseMp) {
        currentMp += increaseMp;
        if (currentMp > maximumMp) {
            currentMp = maximumMp;
        }
    }

    public void decreaseCurrentMp(int decreaseMp) {
        currentMp -= decreaseMp;
    }

    private void validateMp(int mp) {
        if (PLAYER_MINIMUM_MP_LIMIT > mp || PLAYER_MAXIMUM_MP_LIMIT < mp) {
            throw new IllegalArgumentException("유효하지 않은 플레이어 MP입니다.");
        }
    }
}
