package bossmonster.domain.player;

import static bossmonster.domain.player.constant.PlayerOption.PLAYER_MAXIMUM_HP_LIMIT;
import static bossmonster.domain.player.constant.PlayerOption.PLAYER_MINIMUM_HP_LIMIT;

public class PlayerHp {
    private final int maximumHp;
    private int currentHp;

    public PlayerHp(int hp) {
        validateHp(hp);
        this.maximumHp = hp;
        this.currentHp = hp;
    }

    public int getMaximumHp() {
        return maximumHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void decreaseCurrentHp(int decreaseHp) {
        currentHp -= decreaseHp;
        if (currentHp < 0) currentHp = 0;
    }

    public boolean isCurrentHpZeroOrBelow() {
        return currentHp <= 0;
    }

    private void validateHp(int hp) {
        if (PLAYER_MINIMUM_HP_LIMIT > hp || PLAYER_MAXIMUM_HP_LIMIT < hp) {
            throw new IllegalArgumentException("유효하지 않은 플레이어 HP입니다.");
        }
    }
}
